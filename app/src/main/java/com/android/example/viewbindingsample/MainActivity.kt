/*
 * Copyright (C) 2020 The Android Open Source Project
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

package com.android.example.viewbindingsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.android.example.viewbindingsample.R.string
import com.android.example.viewbindingsample.databinding.ActivityMainBinding
import com.android.example.viewbindingsample.databinding.LayoutCommonDataBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var layoutCommonDataBinding: LayoutCommonDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        (binding.btnActivity as AppCompatButton).text = getString(string.hello_from_vb_activity)
        binding.btnActivity.setOnClickListener { _ ->
            startActivity(
                Intent(
                    this,
                    ListActivity::class.java
                )
            )
        }
        initView()
    }


    fun initView() {
//        binding.stub.inflate()
//        binding.stub.tv_content.text = "stub text"
        if (binding.stub.parent != null) {
            layoutCommonDataBinding = LayoutCommonDataBinding.bind(binding.stub.inflate())
            layoutCommonDataBinding.tvContent.text = "stub text"
        }
    }
}
