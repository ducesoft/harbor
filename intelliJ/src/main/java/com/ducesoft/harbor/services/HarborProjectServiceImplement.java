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
package com.ducesoft.harbor.services;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.project.Project;

/**
 * @author coyzeng@gmail.com
 */

public class HarborProjectServiceImplement implements HarborProjectService {

    private final Project project;

    public HarborProjectServiceImplement(Project project) {
        this.project = project;
    }

    @Override
    public Project getProject() {
        return this.project;
    }

    @Override
    public ConsoleView getConsole() {
        return TextConsoleBuilderFactory.getInstance().createBuilder(getProject()).getConsole();
    }
}
