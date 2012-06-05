package com.xenji.php.symfony2.clickableviews;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;
import org.jetbrains.annotations.NotNull;

/**
 * Reference Provider implementation for Twig Templates.
 *
 * @author Mario Mueller mario@xenji.com
 * @license MIT
 */
public class TwigViewPsiReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {

        // IF we touch down here, we do have a StringLiteralExpression.
        StringLiteralExpression se = (StringLiteralExpression) element;

        TwigViewPsiReference psiReference = new TwigViewPsiReference(se, element.getProject());

        if (psiReference.resolve() != null) {
            return new PsiReference[]{psiReference};
        }
        return PsiReference.EMPTY_ARRAY;
    }
}
