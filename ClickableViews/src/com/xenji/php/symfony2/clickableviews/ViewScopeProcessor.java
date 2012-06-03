package com.xenji.php.symfony2.clickableviews;

import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.jetbrains.annotations.Nullable;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 03/06/12
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
public class ViewScopeProcessor implements PsiScopeProcessor {
    @Override
    public boolean execute(PsiElement element, ResolveState state) {
        final String text = element.getText();
        if (text.contains(":") && (text.contains(".twig") || text.contains(".php")))
        {

        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> T getHint(Key<T> hintKey) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void handleEvent(Event event, @Nullable Object associated) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
