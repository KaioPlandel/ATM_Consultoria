package primeiro.cliente.atmconsultoria
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import primeiro.cliente.atmconsultoria.databinding.ActivityMainBinding
import primeiro.cliente.atmconsultoria.databinding.FragmentContactBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,"atmconsultoria@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"Enviar")
            intent.putExtra(Intent.EXTRA_TEXT,"mensagem")
            intent.setType("text/plain")
                startActivity(Intent.createChooser(intent,"compartilhar"))

        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_clients, R.id.nav_work,R.id.nav_contato,R.id.nav_sobre), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }




    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}