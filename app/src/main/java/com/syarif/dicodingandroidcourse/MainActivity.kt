package com.syarif.dicodingandroidcourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.syarif.dicodingandroidcourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null) {
            binding.tvResult.text = savedInstanceState.getString(STATE_RESULT)
        }

        binding.btnCalculate.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        val panjang = binding.edtPanjang.text
        val lebar = binding.edtLebar.text
        val tinggi = binding.edtTinggi.text
        var isEmpty = false

        when (v?.id) {
            R.id.btn_calculate -> {
                if (panjang.isEmpty()) {
                    binding.edtPanjang.error = "Masukkan Panjang"
                    isEmpty = true
                }
                if (lebar.isEmpty()) {
                    binding.edtLebar.error = "Masukkan Lebar"
                    isEmpty = true
                }
                if (tinggi.isEmpty()) {
                    binding.edtTinggi.error = "Masukkan Tinggi"
                    isEmpty = true
                }

                if (!isEmpty) {
                    val hasil =
                        panjang.toString().toInt() * lebar.toString().toInt() * tinggi.toString()
                            .toInt()
                    binding.tvResult.text = hasil.toString()
                }
            }

            R.id.btn_clear -> {
                panjang.clear()
                lebar.clear()
                tinggi.clear()
                binding.tvResult.text = "Hasil"
            }
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }
}

