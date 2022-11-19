package xyz.donggeon.containerrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import xyz.donggeon.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()

    //한 화면에 그려지는 아이템 개수만큼 레이아웃 생성(Holder를 이용해서)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    //생성된아이템 레이아웃에 값 입력 후 목록에 출력
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    //목록에 보여줄 아이템의 개수
    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "클릭된 아이템의 제목 = ${binding.textTitle.text}", Toast.LENGTH_LONG).show()
        }
    }
    fun setMemo(memo: Memo) {
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = "${memo.title}"
        //날짜 포맷 변경
        binding.textDate.text = "${SimpleDateFormat("yyyy년MM월dd일 HH시mm분").format(memo.timestamp)}"
    }


}