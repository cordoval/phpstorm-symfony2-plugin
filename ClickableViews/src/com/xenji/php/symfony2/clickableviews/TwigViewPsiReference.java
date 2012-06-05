package com.xenji.php.symfony2.clickableviews;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.ProjectScope;
import com.intellij.util.IncorrectOperationException;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;
import org.jetbrains.annotations.NotNull;

public class TwigViewPsiReference implements PsiReference {

    private StringLiteralExpression templateString;

    private Project project;

    private PsiFile resolvedFile;

    private String cleanString;

    public TwigViewPsiReference(final StringLiteralExpression templateString, Project project) {
        this.templateString = templateString;
        this.project = project;
        cleanString = templateString.getText().replace("\"", "").replace("'", "");
    }

    @Override
    public PsiElement getElement() {
        return templateString;
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

        final String[] pathElements = cleanString.split(":");

        String base = pathElements[0];
        String ctrl = pathElements[1];
        String viewFileName = pathElements[2];

        final String filename = base + ".php";
        PsiFile[] filesByName = FilenameIndex.getFilesByName(project, filename, ProjectScope.getProjectScope(project));

        if (filesByName.length < 1)
        {
            // We cannot resolve properly. Maybe we can guess in some later version.
            return null;
        }

        PsiFile bundleFile = filesByName[0];
        PsiDirectory bundleDir = bundleFile.getContainingDirectory();

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
        return templateString;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        this.resolvedFile = (PsiFile) element;
        return this.resolvedFile;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        if (element.getClass().equals(PsiFile.class))
        {
            PsiFile templateFile = (PsiFile) element;
            // Controller Dir?
            String ctlDir = templateFile.getParent().getName();
            // xyz.html.twig -> Default -> views -> Resources -> AcmeBundle!
            String bundleDir = templateFile.getParent().getParent().getParent().getParent().getName();
            StringBuilder sb = new StringBuilder(bundleDir).append(":").append(ctlDir).append(":").append(templateFile.getName());
            return cleanString.equals(sb.toString());
        }
        return false;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    @Override
    public boolean isSoft() {
        return true;
    }
}
