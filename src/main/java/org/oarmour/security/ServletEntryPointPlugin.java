/*
 * Tai-e: A Static Analysis Framework for Java
 *
 * Copyright (C) 2022 Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2022 Yue Li <yueli@nju.edu.cn>
 *
 * This file is part of Tai-e.
 *
 * Tai-e is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * Tai-e is distributed in the hope that it will be useful,but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Tai-e. If not, see <https://www.gnu.org/licenses/>.
 */

package org.oarmour.security;

import pascal.taie.analysis.pta.core.heap.Descriptor;
import pascal.taie.analysis.pta.core.heap.HeapModel;
import pascal.taie.analysis.pta.core.heap.Obj;
import pascal.taie.analysis.pta.core.solver.EntryPoint;
import pascal.taie.analysis.pta.core.solver.Solver;
import pascal.taie.analysis.pta.core.solver.SpecifiedParamProvider;
import pascal.taie.analysis.pta.plugin.Plugin;
import pascal.taie.language.classes.ClassHierarchy;
import pascal.taie.language.classes.JClass;
import pascal.taie.language.classes.JMethod;
import pascal.taie.language.type.TypeSystem;

public class ServletEntryPointPlugin implements Plugin {

    private Solver solver;

    private ClassHierarchy hierarchy;

    private TypeSystem typeSystem;

    private HeapModel heapModel;

    @Override
    public void setSolver(Solver solver) {
        this.solver = solver;
        this.hierarchy = solver.getHierarchy();
        this.typeSystem = solver.getTypeSystem();
        this.heapModel = solver.getHeapModel();
    }

    @Override
    public void onStart() {
        JClass servlet = hierarchy.getClass("MyServlet");
        JMethod entryMethod = servlet.getDeclaredMethod("doGet");
        JClass request = hierarchy.getClass("javax.servlet.http.HttpServletRequestWrapper");
        JClass response = hierarchy.getClass("javax.servlet.http.HttpServletResponseWrapper");
        Obj thisObj = heapModel.getMockObj(Descriptor.ENTRY_DESC, "MethodParam{this}", servlet.getType(), entryMethod);
        Obj p0 = heapModel.getMockObj(Descriptor.ENTRY_DESC, "MethodParam{0}", request.getType(), entryMethod);
        Obj p1 = heapModel.getMockObj(Descriptor.ENTRY_DESC, "MethodParam{1}", response.getType(), entryMethod);

        SpecifiedParamProvider.Builder paramProviderBuilder = new SpecifiedParamProvider.Builder(entryMethod);
        paramProviderBuilder.addThisObj(thisObj)
                .addParamObj(0, p0)
                .addParamObj(1, p1);
        solver.addEntryPoint(new EntryPoint(entryMethod, paramProviderBuilder.build()));
//
//        // mock obj
//        JClass requestWrapper = hierarchy.getClass("javax.servlet.http.HttpServletRequestWrapper");
//        JClass responseWrapper = hierarchy.getClass("javax.servlet.http.HttpServletResponseWrapper");
//        Obj mockRequest = heapModel.getMockObj(Descriptor.ENTRY_DESC, "<http-request-wrapper>", requestWrapper.getType(), service);
//        Obj mockResponse = heapModel.getMockObj(Descriptor.ENTRY_DESC, "<http-response-wrapper>", responseWrapper.getType(), service);
//        Obj mockServlet = heapModel.getMockObj(Descriptor.ENTRY_DESC, "<http-controller>", clz.getType(), service);

//        JClass log4j = hierarchy.getClass("Entry");
//        JMethod emptyParam = log4j.getDeclaredMethod("entry");
//        solver.addEntryPoint(new EntryPoint(emptyParam, EmptyParamProvider.get()));
    }
}
