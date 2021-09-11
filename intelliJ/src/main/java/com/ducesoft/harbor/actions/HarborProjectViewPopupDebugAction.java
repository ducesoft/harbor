/*
 * Copyright 1999-2099 Ducesoft Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ducesoft.harbor.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author coyzeng@gmail.com
 */
public class HarborProjectViewPopupDebugAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        System.out.println("'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'");
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        final Presentation presentation = e.getPresentation();
        final Project      project      = e.getProject();
        if (null == project) {
            presentation.setEnabledAndVisible(false);
            return;
        }
        presentation.setEnabledAndVisible(true);
    }
}
