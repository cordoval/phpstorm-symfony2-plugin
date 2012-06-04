package com.xenji.php.symfony2.clickableviews;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;
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
        StringLiteralExpression se = (StringLiteralExpression) element;
        String text = element.getText();
        TwigViewPsiReference psiReference = new TwigViewPsiReference(se, element.getProject());

        if (psiReference.resolve() != null)
        {
            return new PsiReference[]{psiReference};
        }
        return PsiReference.EMPTY_ARRAY;
    }

}
