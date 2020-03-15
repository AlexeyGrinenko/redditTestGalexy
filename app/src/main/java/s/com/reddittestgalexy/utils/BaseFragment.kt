package s.com.reddittestgalexy.utils

import androidx.fragment.app.Fragment
import org.koin.android.ext.android.setProperty

abstract class BaseFragment : Fragment() {

    val koinProperties = HashSet<String>()
    abstract val contextName: String

}

fun BaseFragment.addProperty(key: String, prop: Any) {
    if (koinProperties.add(key)) setProperty(key, prop)
}