/*
 * Copyright (c) 2000, 2099, ducesoft and/or its affiliates. All rights reserved.
 * DUCESOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 */
package com.ducesoft.harbor.bundle;

import com.intellij.execution.ui.ConsoleView;

import java.util.Optional;

/**
 * @author coyzeng@gmail.com
 */
public class ConsoleBundle {

    private ConsoleBundle() {}

    private static final ConsoleBundle instance = new ConsoleBundle();
    private Optional<ConsoleView> console;


}
