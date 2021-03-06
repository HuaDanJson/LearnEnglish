package cool.android.english.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import cool.android.english.R;
import cool.android.english.base.BaseRVAdapter;
import cool.android.english.base.CCApplication;
import cool.android.english.base.IViewHolder;
import cool.android.english.bean.Book;

public class ReaderAdapter extends BaseRVAdapter<Book, ReaderAdapter.ReaderAdapterHolder> {

    @Override
    protected ReaderAdapterHolder doCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ReaderAdapterHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_reader_adapter, viewGroup, false));

    }

    @Override
    protected void bindItemData(ReaderAdapterHolder viewHolder, Book book, int position) {
        viewHolder.bindView(book, position);
    }

    public class ReaderAdapterHolder extends RecyclerView.ViewHolder implements IViewHolder<Book> {

        @BindView(R.id.tv_title_item_book_reader)
        TextView mTitle;
        @BindView(R.id.tv_writer_item_book_reader)
        TextView mWriter;
        @BindView(R.id.tv_introduce_item_book_reader)
        TextView mIntroduce;
        @BindView(R.id.ll_read_all)
        LinearLayout mReadAll;

        public ReaderAdapterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(Book book, int position) {
            mTitle.setText(book.getTitle());
            mWriter.setText(book.getWriter());
            mIntroduce.setText(book.getIntroduce());

            Glide.with(CCApplication.getInstance())
                    .load(book.getCover())
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(final Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            mReadAll.setBackground(new BitmapDrawable(resource));
                        }
                    });

        }
    }
}

