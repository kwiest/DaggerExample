package com.kylewiest.daggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kylewiest.daggerapp.beverage.Session
import com.kylewiest.daggerapp.beverage.cold_brew.ColdBrew
import com.kylewiest.daggerapp.beverage.drip.BellaDonovan
import com.kylewiest.daggerapp.beverage.drip.Drip
import com.kylewiest.daggerapp.beverage.ingredient.Roast
import com.kylewiest.daggerapp.beverage.espresso.Latte
import com.kylewiest.daggerapp.beverage.ingredient.Milk
import com.kylewiest.daggerapp.customer.Customer
import com.kylewiest.daggerapp.customer.Rewards
import com.kylewiest.daggerapp.di.DaggerHotChocolateComponent
import com.kylewiest.daggerapp.di.DaggerMochaComponent
import com.kylewiest.daggerapp.di.HotChocolateModule
import com.kylewiest.daggerapp.di.MochaModule
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orderBellaDonovan()
        orderGiantSteps()
        orderLatte()
        orderHotChocolate()
        orderMocha()
        orderColdBrew()
    }


    /*
     * Bad
     *
     * Inflexible; Roast dependency is tied directly to class
     *
    */
    fun orderBellaDonovan() {
        val beverage = BellaDonovan()
        val order = Order(beverage)

        order.commit()
    }

    /*
     * Better
     *
     * More flexible. Dependencies are injected during instantiation
     *
     */
    fun orderGiantSteps() {
        val beverage = Drip(Roast.GS)
        val order = Order(beverage)

        order.commit()
    }

    /*
     * Complicated and cumbersome. Lots of dependencies need to exist to build up object
     *
     * Dependency graph can grow with application. Imagine repositories or inventory managers
     * that need to exist to lookup ingredient availability.
     *
    */
    fun orderLatte() {
        val roast = Roast.HVE
        val milk = Milk.TWO_PERCENT
        val customer = Customer("kylew@bluebottlecoffee.com")
        val rewards = Rewards(customer.email)
        val location = Location("Old Oakland")

        val beverage = Latte(roast, milk, customer, rewards, location)

        beverage.brew()
    }


    /*
     * Using Dagger
     */
    fun orderHotChocolate() {
        val component = DaggerHotChocolateComponent.builder()
            .hotChocolateModule(HotChocolateModule())
            .build()

        val hotChocolate = component.hotChocolate()
        val order = Order(hotChocolate)

        order.commit()
    }


    /*
     * More complicated Dagger example.
     *
     * Show Dagger _how_ to compose objects
     *
     */
    private val userSession = Session()

    fun orderMocha() {
        val component = DaggerMochaComponent.builder()
            .session(userSession)
            .addHotChocolate(HotChocolateModule())
            .addMochaModule(MochaModule())
            .build()

        val order = component.mochaOrder()

        order.commit()
    }


    /*
     * Android Dagger example
     */

    @Inject
    lateinit var coldBrew: ColdBrew

    fun orderColdBrew() {
        AndroidInjection.inject(this)

        val order = Order(coldBrew)

        order.commit()
    }
}
