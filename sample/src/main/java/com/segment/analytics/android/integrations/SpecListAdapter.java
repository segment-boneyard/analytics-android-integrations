package com.segment.analytics.android.integrations;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.segment.analytics.android.integrations.databinding.SpecItemBinding;
import java.util.List;

public class SpecListAdapter extends RecyclerView.Adapter<SpecListAdapter.SpecViewHolder> {
  private List<String> specList;
  private SpecClickListener specClickListener;

  SpecListAdapter(List<String> specList, SpecClickListener specClickListener) {
    this.specList = specList;
    this.specClickListener = specClickListener;
  }

  @NonNull
  @Override
  public SpecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
    SpecItemBinding binding = SpecItemBinding.inflate(layoutInflater, viewGroup, false);
    return new SpecViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull SpecViewHolder specViewHolder, int i) {
    String string = specList.get(i);
    specViewHolder.bind(string, specClickListener);
  }

  void setSpecList(List<String> specs) {
    specList = specs;
  }

  @Override
  public int getItemCount() {
    if (specList == null) {
      return 0;
    }
    return specList.size();
  }

  class SpecViewHolder extends RecyclerView.ViewHolder {
    SpecItemBinding binding;

    SpecViewHolder(SpecItemBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    void bind(String string, SpecClickListener specClickListener) {
      itemView.setOnClickListener(v -> specClickListener.getSpec(string));
      binding.specText.setText(string);
    }
  }
}
