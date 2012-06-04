package com.xenji.php.symfony2.clickableviews;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 04.06.12
 * Time: 08:03
 * To change this template use File | Settings | File Templates.
 */
public class TwigViewPsiReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        final String viewLink = element.getText();

        if (viewLink.contains(".twig") && viewLink.contains(":"))
        {
            return new TwigViewPsiReference[]{new TwigViewPsiReference(element.getText(), element.getProject())};
        }
        return new TwigViewPsiReference[]{};
    }

}
