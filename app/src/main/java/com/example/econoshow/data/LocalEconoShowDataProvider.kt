package com.example.econoshow.data

import androidx.compose.ui.layout.Layout
import com.example.econoshow.model.MachineType
import com.example.econoshow.R
import com.example.econoshow.model.Layout
import com.example.econoshow.model.Machine
import com.example.econoshow.model.Video

object LocalEconoShowDataProvider {
    val defaultMachine = getMachineTypeData()[0]

    fun getMachineTypeData(): List<MachineType> {
        return listOf(
            MachineType(
                id = 1,
                titleResourceId = R.string.machineType_01_title,
                subtitleResourceId = R.string.machineType_01_subtitle,
            ),
            MachineType(
                id = 2,
                titleResourceId = R.string.machineType_02_title,
                subtitleResourceId = R.string.machineType_02_subtitle,
            ),
            MachineType(
                id = 3,
                titleResourceId = R.string.machineType_03_title,
                subtitleResourceId = R.string.machineType_03_subtitle,
            ),
            MachineType(
                id = 4,
                titleResourceId = R.string.machineType_04_title,
                subtitleResourceId = R.string.machineType_04_subtitle,
            )
        )
    }

    //We could maybe add in a field on the machine that tells us whether it's a
    //cartoner, caser, or trayformer, but hard to know for certain atm

    fun getCartonerMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 1,
                name = R.string.machine_miniMono_name,
                brochure = R.raw.brochure_mini_mono,
                videos = listOf(
                    Video(
                        id = 1,
                        titleRes = R.string.video_title_mini_mono_01,
                        videoRes = R.raw.youtube_mini_mono_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_mini_mono_01,
                    ),
                    Video(
                        id = 2,
                        titleRes = R.string.video_title_mini_mono_02,
                        videoRes = R.raw.youtube_mini_mono_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_mini_mono_02
                    )
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_minimono_01,
                        layoutRes = R.raw.layout_mini_mono_01,
                    )
                )
            ),
            Machine(
                id = 2,
                name = R.string.machine_twinseal_name,
                brochure = R.raw.brochure_twinseal,
                videos = listOf(
                    Video(
                        id = 3,
                        titleRes = R.string.video_title_twinseal_01,
                        videoRes = R.raw.youtube_twinseal_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_twinseal_01,
                    ),
                    Video(
                        id = 4,
                        titleRes = R.string.video_title_twinseal_02,
                        videoRes = R.raw.youtube_twinseal_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_twinseal_02,
                    ),
                    Video(
                        id = 5,
                        titleRes = R.string.video_title_twinseal_03,
                        videoRes = R.raw.youtube_twinseal_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_twinseal_03
                    )
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_twinseal_01,
                        layoutRes = R.raw.layout_twinseal_01
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_twinseal_02,
                        layoutRes = R.raw.layout_twinseal_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_twinseal_03,
                        layoutRes = R.raw.layout_twinseal_03,
                    )
                )
            ),
            Machine(
                id = 3,
                name = R.string.machine_e2000_name,
                brochure = R.raw.brochure_e_2000,
                videos = listOf(
                    Video(
                        id = 6,
                        titleRes = R.string.video_title_e_2000_01,
                        videoRes = R.raw.youtube_e_2000_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_e_2000_01
                    ),
                    Video(
                        id = 7,
                        titleRes = R.string.video_title_e_2000_02,
                        videoRes = R.raw.youtube_e_2000_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_e_2000_02
                    ),
                    Video(
                        id = 8,
                        titleRes = R.string.video_title_e_2000_03,
                        videoRes = R.raw.youtube_e_2000_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_e_2000_03
                    ),
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_e_2000_01,
                        layoutRes = R.raw.layout_e_2000_01
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_e_2000_02,
                        layoutRes = R.raw.layout_e_2000_02
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_e_2000_03,
                        layoutRes = R.raw.layout_e_2000_03
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_e_2000_04,
                        layoutRes = R.raw.layout_e_2000_04
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_e_2000_05,
                        layoutRes = R.raw.layout_e_2000_05
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_e_2000_06,
                        layoutRes = R.raw.layout_e_2000_06
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_e_2000_07,
                        layoutRes = R.raw.layout_e_2000_07
                    ),
                )
            ),
            Machine(
                id = 4,
                name = R.string.machine_spartan_name,
                brochure = R.raw.brochure_spartan,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_01,
                        videoRes = R.raw.youtube_spartan_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_02,
                        videoRes = R.raw.youtube_spartan_02_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_02,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_03,
                        videoRes = R.raw.youtube_spartan_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_03,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_04,
                        videoRes = R.raw.youtube_spartan_04_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_04,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_05,
                        videoRes = R.raw.youtube_spartan_05_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_05,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_06,
                        videoRes = R.raw.youtube_spartan_06_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_06,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_07,
                        videoRes = R.raw.youtube_spartan_07_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_07,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_08,
                        videoRes = R.raw.youtube_spartan_08_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_08,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_09,
                        videoRes = R.raw.youtube_spartan_09_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_09,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_10,
                        videoRes = R.raw.youtube_spartan_10_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_10,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_11,
                        videoRes = R.raw.youtube_spartan_11_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_11,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_12,
                        videoRes = R.raw.youtube_robotics_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_robotics_01,
                    ),
                )
            ),
            Machine(
                id = 5,
                name = R.string.machine_spartan_plus_name,
                brochure = R.raw.brochure_spartan_plus,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_plus_01,
                        videoRes = R.raw.youtube_spartan_plus_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_plus_01,
                    ),
                )
            ),
            Machine(
                id = 6,
                name = R.string.machine_spartan_m_pro_name,
                brochure = R.raw.brochure_spartan_m_pro_cartoner,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_m_pro_01,
                        videoRes = R.raw.youtube_spartan_m_pro_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_m_pro_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_spartan_m_pro_02,
                        videoRes = R.raw.youtube_spartan_m_pro_02_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_spartan_m_pro_02,
                    ),
                )
            ),
            Machine(
                id = 7,
                name = R.string.machine_vSystem_name,
                brochure = R.raw.brochure_v_system,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_v_system_01,
                        videoRes = R.raw.youtube_v_system_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_v_system_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_v_system_02,
                        videoRes = R.raw.youtube_v_system_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_v_system_02,
                    ),
                )
            ),
            Machine(
                id = 8,
                name = R.string.machine_e60_name,
                brochure = R.raw.brochure_econo_60,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_econo_60_01,
                        videoRes = R.raw.youtube_econo_60_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_econo_60_01,
                    ),
                )
            ),
            Machine(
                id = 9,
                name = R.string.machine_pegasus_name,
                brochure = R.raw.brochure_pegasus,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_pegasus_01,
                        videoRes = R.raw.youtube_pegasus_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_pegasus_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_pegasus_02,
                        videoRes = R.raw.youtube_pegasus_02_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_pegasus_02,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_pegasus_03,
                        videoRes = R.raw.youtube_pegasus_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_pegasus_03,
                    ),
                )
            ),
            Machine(
                id = 10,
                name = R.string.machine_autoBottom_name,
                brochure = R.raw.brochure_auto_bottom_erector,
            ),
            Machine(
                id = 11,
                name = R.string.machine_argo_name,
                brochure = R.raw.brochure_argo,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_argo_01,
                        videoRes = R.raw.youtube_argo_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_argo_01
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_argo_02,
                        videoRes = R.raw.youtube_argo_02_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_argo_02
                    )
                )
            )
        )
    }

    fun getTrayformerMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 12,
                name = R.string.machine_formlock_name,
                brochure = R.raw.brochure_econoformlock,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_trayformer_01,
                        videoRes = R.raw.youtube_trayformer_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_trayformer_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_trayformer_02,
                        videoRes = R.raw.youtube_trayformer_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_trayformer_02,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_trayformer_03,
                        videoRes = R.raw.youtube_trayformer_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_trayformer_03,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_trayformer_04,
                        videoRes = R.raw.youtube_trayformer_04_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_trayformer_04,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_trayformer_05,
                        videoRes = R.raw.youtube_trayformer_05_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_trayformer_05,
                    ),
                )
            ),
            Machine(
                id = 13,
                name = R.string.machine_revTriseal_name,
                brochure = R.raw.brochure_reverse_triseal,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_reverse_triseal_01,
                        videoRes = R.raw.youtube_t_system_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_t_system_03
                    ),
                )
            ),
            Machine(
                id = 14,
                name = R.string.machine_tSystem_name,
                brochure = R.raw.brochure_t_system,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_t_system_01,
                        videoRes = R.raw.youtube_t_system_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_t_system_01
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_t_system_02,
                        videoRes = R.raw.youtube_t_system_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_t_system_02
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_t_system_03,
                        videoRes = R.raw.youtube_t_system_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_t_system_03
                    ),
                )
            )
        )
    }

    fun getCasepackingMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 15,
                name = R.string.machine_packer_name,
                brochure = R.raw.brochure_econopacker,
            ),
            Machine(
                id = 16,
                name = R.string.machine_caser_name,
                brochure = R.raw.brochure_econocaser,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_01,
                        videoRes = R.raw.youtube_caser_01_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_01,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_02,
                        videoRes = R.raw.youtube_caser_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_02,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_03,
                        videoRes = R.raw.youtube_caser_03_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_03,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_04,
                        videoRes = R.raw.youtube_caser_04_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_04,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_05,
                        videoRes = R.raw.youtube_caser_05_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_05,
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_caser_06,
                        videoRes = R.raw.youtube_caser_06_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_caser_06,
                    ),
                )
            ),
            Machine(
                id = 17,
                name = R.string.machine_wrapAround_name,
                brochure = R.raw.brochure_wrap_around_spartan,
                videos = listOf(
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_wrap_around_spartan_01,
                        videoRes = R.raw.youtube_wrap_around_spartan_01_1920x1080_h264,
                        thumbnailRes = R.drawable.video_thumbnail_wrap_around_spartan_01
                    ),
                    Video(
                        id = 9999,
                        titleRes = R.string.video_title_wrap_around_spartan_02,
                        videoRes = R.raw.youtube_wrap_around_spartan_02_1280x720_h264,
                        thumbnailRes = R.drawable.video_thumbnail_wrap_around_spartan_02
                    )
                )
            )
        )
    }

    fun getRoboticsMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 18,
                name = R.string.machine_robot_palletizer,
                brochure = R.raw.brochure_palletizer,
            ),
            Machine(
                id = 19,
                name = R.string.machine_robot_case_packer,
            )
        )
    }
}