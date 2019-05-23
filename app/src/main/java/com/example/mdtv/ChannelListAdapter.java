package com.example.mdtv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHolder>{
    /**
     * 定义点击事件接口
     */
    public interface OnItemClickListener {
        void onClick(int position);
    }

    public interface OnItemLongClickListener {
        void onClick(int position);
    }

    private OnItemClickListener listener;
    private OnItemLongClickListener longListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longListener) {
        this.longListener = longListener;
    }

    /**
     * 找到电影行对应的xml
     */
    public ChannelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View container = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.channel_view, viewGroup, false);
        return new ChannelViewHolder(container);
    }


    /**
     * 填充每一行内容
     */
    public void onBindViewHolder(ChannelViewHolder channelViewHolder, final int i) {
        channelViewHolder.bind(ChannelLab.get().getTv(i),i);
        channelViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(i);
                }
            }
        });
        channelViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longListener != null) {
                    longListener.onClick(i);
                }
                return true;
            }
        });
    }

    public int getItemCount() {
        return ChannelLab.get().getSize();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        private TextView moveName;
        private ImageView imageView;
        private int[] img={
                R.drawable.c1,
                R.drawable.c4,
                R.drawable.c12,
                R.drawable.c13,
                R.drawable.chc,
                R.drawable.hn,
        };
        public ChannelViewHolder(View container) {
            super(container);
            moveName = container.findViewById(R.id.move_Name);
            imageView = container.findViewById(R.id.move_img);
        }

        public void bind(String moveName,int i) {
            this.moveName.setText(moveName);
            this.imageView.setImageResource(img[i]);
        }
    }
}



