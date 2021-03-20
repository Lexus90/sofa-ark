/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.ark.trace;

import cn.lalaframework.jaf.monitor.exporter.MonitorServer;
import com.alipay.sofa.ark.spi.model.Plugin;
import com.alipay.sofa.ark.spi.model.PluginContext;
import com.alipay.sofa.ark.spi.service.PluginActivator;
import com.alipay.sofa.ark.trace.facade.ITrace;
import com.alipay.sofa.ark.trace.impl.TraceImpl;

public class TracePluginActivator implements PluginActivator {
    @Override
    public void start(PluginContext context) {
//        Config.Agent.INSTANCE_NAME = ConfigUtil.getIp();
        MonitorServer.start();

        context.publishService(ITrace.class, new TraceImpl());
    }

    @Override
    public void stop(PluginContext context) {
        Plugin plugin = context.getPlugin("trace-ark-plugin");
        System.out.println("plugin name = " + plugin.getPluginActivator());
    }
}
