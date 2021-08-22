package com.android.example.viewbindingsample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.viewbindingsample.data.VideoInfo
import com.android.example.viewbindingsample.databinding.ActivityListBinding
import com.android.example.viewbindingsample.databinding.ItemVideoBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private var videoAdaptor: VideoAdaptor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoAdaptor = VideoAdaptor()
        videoAdaptor?.data = initData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = videoAdaptor
        videoAdaptor?.notifyDataSetChanged()
    }

    private fun initData(): ArrayList<VideoInfo> {
        var dataList = ArrayList<VideoInfo>()
        for (i in 0..10) {
            dataList.add(VideoInfo(i.toString(), ""))
        }
        return dataList
    }

    class VideoAdaptor : RecyclerView.Adapter<VideoHolder>() {
        var data: ArrayList<VideoInfo>? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
            return VideoHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            )
        }

        override fun onBindViewHolder(holder: VideoHolder, position: Int) {
            Log.d("test", "onBindViewHolder")
            holder.binding.tvTitle.text = data?.get(position)?.title ?: ""
        }

        override fun getItemCount(): Int {
            Log.d("test", "${data?.size ?: 0}")
            return data?.size ?: 0
        }
    }

    class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemVideoBinding = ItemVideoBinding.bind(itemView)
    }
}