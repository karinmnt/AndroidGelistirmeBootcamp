package com.example.xbox.ui.gamepass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.xbox.data.repository.GameRepository
import com.example.xbox.databinding.FragmentGamePassBinding
import com.example.xbox.ui.adapters.BlokAdapter
import com.example.xbox.ui.adapters.CategoryAdapter
import com.example.xbox.ui.adapters.ComingAdapter
import com.example.xbox.ui.adapters.DayOneAdapter
import com.example.xbox.ui.adapters.GameCardAdapter
import com.example.xbox.ui.adapters.MostPopularAdapter
import com.example.xbox.ui.adapters.PerksAdapter

class GamePassFragment : Fragment() {
    private lateinit var binding: FragmentGamePassBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGamePassBinding.inflate(inflater,container,false)

        val oyunlarListesi = ArrayList<Oyunlar>()
        val o1 = Oyunlar("clairobscure")
        val o2 = Oyunlar("farcry")
        val o3 = Oyunlar("doom")
        val o4 = Oyunlar("anno")
        val o5 = Oyunlar("dredge")
        val o6 = Oyunlar("ninja")
        val o7 = Oyunlar("revengeofthesavageplanet")
        val o8 = Oyunlar("towerborne")
        val o9 = Oyunlar("warhammer")

        oyunlarListesi.add(o1)
        oyunlarListesi.add(o2)
        oyunlarListesi.add(o3)
        oyunlarListesi.add(o4)
        oyunlarListesi.add(o5)
        oyunlarListesi.add(o6)
        oyunlarListesi.add(o7)
        oyunlarListesi.add(o8)
        oyunlarListesi.add(o9)


        val oyunlarAdapter = GameCardAdapter(requireContext(),oyunlarListesi)
        binding.rvRecently.adapter = oyunlarAdapter

        binding.rvRecently.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val perkListesi = ArrayList<Perks>()
        val p1 = Perks("Metaball","Neon Robot Bundle","Claim by 6/15/2025","metaball")
        val p2 = Perks("World of Tanks Modern Armor","Steel Raiders","Claim by 6/12/2025","wot")
        val p3 = Perks("Phantasy Star Online 2 New Genesis","May Member Monthly Bonus","Claim by 6/3/2025","newgenesis")
        val p4 = Perks("Apex Legends","Prodigy Supercharge Pack","Claim by 6/2/2025","apex")
        val p5 = Perks("UFL","Game Pass Bonus Perk","Claim by 6/30/2025","ufl")
        val p6 = Perks("Vigor","Sunflower Army Pack","Claim by 6/8/2025","vigor")
        val p7 = Perks("Sea of Thieves","Seventh Serving Emote","Claim by 5/26/2025","sot")
        val p8 = Perks("Discord Nitro","3 Free Months of Nitro","Claim by 2/28/2025","dc")


        perkListesi.add(p1)
        perkListesi.add(p2)
        perkListesi.add(p3)
        perkListesi.add(p4)
        perkListesi.add(p5)
        perkListesi.add(p6)
        perkListesi.add(p7)
        perkListesi.add(p8)



        val perksAdapter = PerksAdapter(requireContext(),perkListesi)
        binding.rvPerks.adapter = perksAdapter

        binding.rvPerks.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val blokListesi = ArrayList<Bloklar>()
        val b1 = Bloklar("crashb")
        val b2 = Bloklar("afb")
        val b3 = Bloklar("cob")
        val b4 = Bloklar("fhb")
        val b5 = Bloklar("balatrob")
        val b6 = Bloklar("sotb")
        val b7 = Bloklar("pwb")
        val b8 = Bloklar("doomb")


        blokListesi.add(b1)
        blokListesi.add(b2)
        blokListesi.add(b3)
        blokListesi.add(b4)
        blokListesi.add(b5)
        blokListesi.add(b6)
        blokListesi.add(b7)
        blokListesi.add(b8)



        val blokAdapter = BlokAdapter(requireContext(),blokListesi)
        binding.rvblok.adapter = blokAdapter

        binding.rvblok.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val comingListesi = ArrayList<Coming>()
        val c1 = Coming("20.05.2025","ffs")
        val c2 = Coming("20.05.2025","pols")
        val c3 = Coming("13.06.2025","alters")
        val c4 = Coming("24.07.2025","wuchang")



        comingListesi.add(c1)
        comingListesi.add(c2)
        comingListesi.add(c3)
        comingListesi.add(c4)




        val comingAdapter = ComingAdapter(requireContext(),comingListesi)
        binding.rvComing.adapter = comingAdapter

        binding.rvComing.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val mostPopularListesi = ArrayList<MostPopular>()
        val m1 = MostPopular("fc")
        val m2 = MostPopular("mc")
        val m3 = MostPopular("codw")
        val m4 = MostPopular("codbp")
        val m5 = MostPopular("gta")
        val m6 = MostPopular("clairobscure")
        val m7 = MostPopular("ninja")
        val m8 = MostPopular("itt")

        mostPopularListesi.add(m1)
        mostPopularListesi.add(m2)
        mostPopularListesi.add(m3)
        mostPopularListesi.add(m4)
        mostPopularListesi.add(m5)
        mostPopularListesi.add(m6)
        mostPopularListesi.add(m7)
        mostPopularListesi.add(m8)

        val mostPopularAdapter = MostPopularAdapter(requireContext(),mostPopularListesi)
        binding.rvMostPopular.adapter = mostPopularAdapter

        binding.rvMostPopular.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val dayOneListesi = ArrayList<DayOne>()
        val d1 = DayOne("doom")
        val d2 = DayOne("revengeofthesavageplanet")
        val d3 = DayOne("clairobscure")
        val d5 = DayOne("blueprince")
        val d6 = DayOne("som")
        val d7 = DayOne("atomfall")


        dayOneListesi.add(d1)
        dayOneListesi.add(d2)
        dayOneListesi.add(d3)
        dayOneListesi.add(d5)
        dayOneListesi.add(d6)
        dayOneListesi.add(d7)


        val dayOneAdapter = DayOneAdapter(requireContext(),dayOneListesi)
        binding.rvDayOne.adapter = dayOneAdapter

        binding.rvDayOne.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }

        val categoryListesi = ArrayList<Category>()
        val ca1 = Category("Indies")
        val ca2 = Category("Family & kids")
        val ca3 = Category("Shooter")
        val ca4 = Category("Simulation")
        val c5 = Category("Action & adventure")
        val c6 = Category("Role Playing")
        val c7 = Category("Sports")
        val c8 = Category("Platformer")

        categoryListesi.add(ca1)
        categoryListesi.add(ca2)
        categoryListesi.add(ca3)
        categoryListesi.add(ca4)
        categoryListesi.add(c5)
        categoryListesi.add(c6)
        categoryListesi.add(c7)
        categoryListesi.add(c8)

        val categoryAdapter = CategoryAdapter(requireContext(),categoryListesi)
        binding.rvCategory.adapter = categoryAdapter


        binding.rvCategory.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)





        return binding.root
    }




}
