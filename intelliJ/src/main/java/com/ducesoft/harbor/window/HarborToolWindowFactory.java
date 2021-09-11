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
package com.ducesoft.harbor.window;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import icons.HarborIcons;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author coyzeng@gmail.com
 */
public class HarborToolWindowFactory implements ToolWindowFactory {

    @Override
    public void init(@NotNull ToolWindow toolWindow) {
        List<AnAction> actions = new ArrayList<>();
        actions.add(ActionManager.getInstance().getAction("HarborToolTestCreateAction"));
        actions.add(ActionManager.getInstance().getAction("HarborToolTestCopyAction"));
        actions.add(ActionManager.getInstance().getAction("HarborToolTestRemoveAction"));
        toolWindow.setTitle("HarborHome");
        toolWindow.setStripeTitle("HarborHome");
        toolWindow.setIcon(HarborIcons.ICON);
        toolWindow.setTitleActions(actions);
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        HarborTestsEditorWindow harborEditor     = new HarborTestsEditorWindow(toolWindow);
        ContentFactory        contentFactory = ContentFactory.SERVICE.getInstance();
        Content               content        = contentFactory.createContent(harborEditor, "Harbor", false);
        toolWindow.getContentManager().addContent(content);
    }
}
