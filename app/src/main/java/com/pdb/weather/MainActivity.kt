package com.pdb.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.pdb.weather.data.model.AppConverters
import com.pdb.weather.databinding.ActivityMainBinding
import com.pdb.weather.utils.Decompress

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Decompress("city.list.json.gz", "src/main/assets/city.list.json.zip")

        val appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "weather_db")                                                            .build()

/*        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
    }
*/
/*        override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.fragment_main)
            return navController.navigateUp() || super.onSupportNavigateUp()
        }
*/
    }
}