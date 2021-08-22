View Binding Sample
=============================================

This sample requires Android Studio 3.6+ and showcases the following Architecture Components:

* [View Binding](https://developer.android.com/topic/libraries/view-binding)

This project shows how to use view bindings in an activity and in fragments. `InflateFragment`
uses the `inflate()` API and `BindFragment` shows the less common `bind()` API.

License
--------

Copyright 2020 The Android Open Source Project, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.


# 视图绑定-ViewBinding

- 代码里面找到view
- 开启方式
- 如何使用
- 注意事项
- 优势

## 开启方式
在需要使用的modlue中添加如下设置：

Android studio agp 3.6

    android {
		...
    	viewBinding {
    		enabled = true
    	}
    }

Android stduio agp 4.0

    android {
    	...
    	buildFeatures {
    		viewBinding true
    	}
    }

编译时，会为所有布局xml文件生成Binding类。

##如下场景，如何使用：
activity
fragment
RecyclerView
inclue
merge

不需要viewbinding类，如何避免：
在xml文件跟布局设置：

    <LinearLayout
    	...
    	tools:viewBindingIgnore="true" >
    	...
    </LinearLayout>

##注意事项：

- fragment中，binding对象需要手动置null
- 引用merge标签，且直接在xml中设置id，会报空指针异常：
  Missing required view with ID:

##优势：
避免空指针
避免View类型转换问题

