package com.example.chap11drawyer.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chap11drawyer.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {

  private var _binding: FragmentMypageBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val mypageViewModel =
      ViewModelProvider(this).get(MypageViewModel::class.java)

    _binding = FragmentMypageBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textMypage
    mypageViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }
    return root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}