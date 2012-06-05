package com.xenji.php.symfony2.clickableviews;


import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.patterns.StandardPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;

/**
 * Reference Contributor implementation for Twig Templates.
 *
 * @author Mario Mueller mario@xenji.com
 * @license MIT
 */
public class TwigViewPsiRerferenceContributor extends PsiReferenceContributor {

    /**
     * Registers the reference provider for any string in php files that match the regex for
     * a single or double quoted string like: "AcmeBundle:Default:index.html.twig".
     *
     * @param registrar
     */
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
