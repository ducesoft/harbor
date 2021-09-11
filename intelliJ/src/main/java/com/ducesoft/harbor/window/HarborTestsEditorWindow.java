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

import com.ducesoft.harbor.javascript.JavaScriptEndpoint;
import com.ducesoft.harbor.javascript.ScriptEndpoint;
import com.ducesoft.harbor.services.HarborProjectService;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.wm.ToolWindow;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import netscape.javascript.JSObject;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author coyzeng@gmail.com
 */
public class HarborTestsEditorWindow extends JComponent implements EventHandler<WebEvent<String>>,
                                                                 Callback<String, Boolean>,
                                                                 ChangeListener<Object> {
    private final JFXPanel       editor = new JFXPanel();
    private final Deque<WebView> view   = new ArrayDeque<>(1);

    public HarborTestsEditorWindow(ToolWindow toolWindow) {
        SwingUtilities.invokeLater(this::initView);
    }

    @Override
    public void handle(WebEvent<String> event) {

    }

    @Override
    public Boolean call(String param) {
        return true;
    }

    @Override
    public void changed(ObservableValue<?> observable, Object older, Object newer) {
        WebEngine engine = view.peek().getEngine();
        if (newer == Worker.State.SUCCEEDED) {
            engine.executeScript(
                    "document.addEventListener('click', function(event) { alert(event.target.id); app.getCallBack(event.target.id);}, false);");
        }
    }

    private void initView() {
        Platform.setImplicitExit(false);
        Platform.runLater(this::initWebView);
        HarborProjectService projectService = ServiceManager.getService(HarborProjectService.class);
        if (null == projectService) {
            return;
        }
        ConsoleView console = projectService.getConsole();
        console.print("测试", ConsoleViewContentType.ERROR_OUTPUT);
    }

    private void initWebView() {
        view.push(new WebView());
        WebView   browser = view.peek();
        WebEngine engine  = browser.getEngine();
        engine.getLoadWorker().stateProperty().addListener(this);
        engine.load("/webview/HarborTestsEditor.html");
        engine.setOnAlert(this);
        engine.setConfirmHandler(this);
        engine.setJavaScriptEnabled(true);
        ScriptEndpoint endpoint = new JavaScriptEndpoint();
        JSObject       window   = (JSObject) engine.executeScript("window");
        window.setMember("endpoint", endpoint);
        Scene scene = new Scene(browser);
        editor.setScene(scene);
        JFrame frame = new JFrame("HarborHome");
        frame.add(editor);
        frame.setVisible(true);
        this.add(frame);
    }

}
