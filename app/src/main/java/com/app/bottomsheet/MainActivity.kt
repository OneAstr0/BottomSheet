package com.app.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var selectItem:TextView
    private lateinit var dialog: BottomSheetDialog
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectItem = findViewById(R.id.tvSelectItem)
        for (i in 1..10) {
            list.add("item $i")
        }

        selectItem.setOnClickListener {
            showBottomSheet()
        }

    }

    private fun showBottomSheet() {
        var dialogView = layoutInflater.inflate(R.layout.bottom_sheet, null)
        dialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        recyclerView = dialogView.findViewById(R.id.rvItem)
        itemAdapter = ItemAdapter(list)
        recyclerView.adapter = itemAdapter
        dialog.show()
    }
}