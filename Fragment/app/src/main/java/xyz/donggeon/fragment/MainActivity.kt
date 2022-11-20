package xyz.donggeon.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.donggeon.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()


    }
    fun setFragment() {
        val listFragment: ListFragment = ListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }
}