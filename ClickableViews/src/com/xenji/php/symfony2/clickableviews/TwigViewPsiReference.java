package com.xenji.php.symfony2.clickableviews;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.impl.DirectoryIndexImpl;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.indexing.FileBasedIndex;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 04.06.12
 * Time: 08:09
 * To change this template use File | Settings | File Templates.
 */
public class TwigViewPsiReference implements PsiReference {

    private StringLiteralExpression templateString;

    private Project project;

    private PsiFile resolvedFile;

    private PsiDirectory bundleDir;

    private PsiDirectory controllerDir;

    private PsiDirectory viewDir;

    public TwigViewPsiReference(final StringLiteralExpression templateString, Project project) {
        this.templateString = templateString;
        this.project = project;
    }

    @Override
    public PsiElement getElement() {
        return resolvedFile;
    }

    @Override
    public TextRange getRangeInElement() {
        return this.templateString.getTextRange();
    }

    @Override
    public PsiElement resolve() {

        if (resolvedFile != null)
        {
            return resolvedFile;
        }

        final String[] pathElements = templateString.getText().split(":");

        String base = pathElements[0].replace("\"", "");
        base = base.replace("'", "");
        String ctrl = pathElements[1];
        String viewFileName = pathElements[2].replace("\"", "").replace("'", "");

        final String filename = base + ".php";
        PsiFile[] filesByName = FilenameIndex.getFilesByName(project, filename, ProjectScope.getProjectScope(project));
        if (filesByName.length < 1)
        {
            // We cannot resolve properly. Maybe we can guess in some later version.
            return null;
        }
        PsiFile bundleFile = filesByName[0];
        this.bundleDir = bundleFile.getContainingDirectory();

        PsiDirectory resourcesDir = bundleDir.findSubdirectory("Resources");
        PsiDirectory viewsDir = resourcesDir.findSubdirectory("views");
        PsiDirectory ctlDir = viewsDir.findSubdirectory(ctrl);
        resolvedFile = ctlDir.findFile(viewFileName);
        return resolvedFile;
    }

    @NotNull
    @Override
    public String getCanonicalText() {
        return this.templateString.getText();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        try {
            this.resolvedFile.getVirtualFile().rename(this, newElementName);
        } catch (IOException e) {
            throw new IncorrectOperationException(e.getMessage(), e);
        }
        return resolvedFile;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        return null;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        return false;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isSoft() {
        return true;
    }
}
