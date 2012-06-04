package com.xenji.php.symfony2.clickableviews;

import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.patterns.StandardPatterns;
import com.intellij.patterns.StringPattern;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 04.06.12
 * Time: 08:57
 * To change this template use File | Settings | File Templates.
 */
public class TwigViewPsiRerferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        StringPattern stringPattern = StandardPatterns.string();
        StringPattern finalPattern = stringPattern.contains(":").and(StandardPatterns.string().contains(".twig"));
        
    }


}
