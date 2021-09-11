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
package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author coyzeng@gmail.com
 */
public final class HarborIcons {

    private HarborIcons() {
        throw new AssertionError("icons.HarborIcons instances for you!");
    }

    public static final Icon ICON = IconLoader.getIcon("/icons/pluginIcon.svg");

    public static final Icon RUN = IconLoader.getIcon("/actions/run_anything.svg");

    public static final Icon DEBUG = IconLoader.getIcon("/actions/restartDebugger.svg");

    public static final Icon SAVE = IconLoader.getIcon("/actions/menu-saveall.svg");

    public static final Icon UPLOAD = IconLoader.getIcon("/actions/upload.svg");

    public static final Icon DOWNLOAD = IconLoader.getIcon("/actions/download.svg");

    public static final Icon REFRESH = IconLoader.getIcon("/actions/refresh.svg");

    public static final Icon RERUN = IconLoader.getIcon("/actions/rerun.svg");

    public static final Icon COPY = IconLoader.getIcon("/actions/copy.svg");

    public static final Icon REMOVE = IconLoader.getIcon("/actions/deleteTagHover.svg");

    public static final Icon CREATE = IconLoader.getIcon("/actions/deleteTagHover.svg");
}
