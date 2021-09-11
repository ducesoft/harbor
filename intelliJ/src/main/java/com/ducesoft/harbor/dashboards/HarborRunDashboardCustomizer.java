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
package com.ducesoft.harbor.dashboards;

import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.dashboard.RunDashboardCustomizer;
import com.intellij.execution.ui.RunContentDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author coyzeng@gmail.com
 */
public class HarborRunDashboardCustomizer extends RunDashboardCustomizer {


    @Override
    public boolean isApplicable(@NotNull RunnerAndConfigurationSettings settings,
            @Nullable RunContentDescriptor descriptor) {
        return false;
    }
}
