package com.xenji.php.symfony2.clickableviews;

import com.intellij.patterns.*;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;

public class TwigViewPsiRerferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        final String regexp = "['\"][\\w]*:[\\w]*:[\\w]+\\.[a-z]+\\.twig[\"']";

        PsiElementPattern.Capture<StringLiteralExpression> psiElementCapture = PlatformPatterns.psiElement(
                StringLiteralExpression.class).withText(StandardPatterns.string().matches(regexp));

        registrar.registerReferenceProvider(
                psiElementCapture,
                new TwigViewPsiReferenceProvider(),
                PsiReferenceRegistrar.DEFAULT_PRIORITY);
    }
}
