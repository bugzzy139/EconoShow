package econoshow.data

import com.example.econoshow.R
import com.example.econoshow.model.Layout
import com.example.econoshow.model.Machine
import com.example.econoshow.model.MachineType
import com.example.econoshow.model.Video

/**
 * The local database in the form of a Kotlin object
 *
 * This was the technique taught in the beginning of the Kotlin courses. Using an actual database with Room would likely be better, but
 * this should be sufficient enough.
 *
 * @property defaultMachine Provides a single basic [MachineType] object, which was used for testing.
 */
object LocalEconoShowDataProvider {
    val defaultMachine = getMachineTypeData()[0]

    /**
     * Gets the different types of machines
     *
     * i.e. Cartoning, Trayforming, Casepacking, Robotics, and Beverage
     *
     * @return The list of [MachineType] objects used in the [com.example.econoshow.ui.MachineTypesScreen]
     */
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
            ),
            MachineType(
                id = 5,
                titleResourceId = R.string.machineType_05_title,
                subtitleResourceId = R.string.machineType_05_subtitle,
            )
        )
    }

    //We could maybe add in a field on the machine that tells us whether it's a
    //cartoner, caser, or trayformer, but hard to know for certain atm
    /**
     * Gets the different cartoner machines
     *
     * Used in tandem with the [com.example.econoshow.ui.MachineTypesScreen] to display the correct info onto the
     * [com.example.econoshow.ui.MachinesScreen]
     *
     * @return The list of [Machine] for specifically Cartoners.
     */
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_spartan_01,
                        layoutRes = R.raw.layout_spartan_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_spartan_02,
                        layoutRes = R.raw.layout_spartan_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_spartan_03,
                        layoutRes = R.raw.layout_spartan_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_spartan_04,
                        layoutRes = R.raw.layout_spartan_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_spartan_05,
                        layoutRes = R.raw.layout_spartan_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_spartan_06,
                        layoutRes = R.raw.layout_spartan_06,
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_spartan_07,
                        layoutRes = R.raw.layout_spartan_07,
                    ),
                    Layout(
                        id = 8,
                        titleRes = R.string.layout_title_spartan_08,
                        layoutRes = R.raw.layout_spartan_08,
                    ),
                    Layout(
                        id = 9,
                        titleRes = R.string.layout_title_spartan_09,
                        layoutRes = R.raw.layout_spartan_09,
                    ),
                    Layout(
                        id = 10,
                        titleRes = R.string.layout_title_spartan_10,
                        layoutRes = R.raw.layout_spartan_10,
                    ),
                    Layout(
                        id = 11,
                        titleRes = R.string.layout_title_spartan_11,
                        layoutRes = R.raw.layout_spartan_11,
                    ),
                    Layout(
                        id = 12,
                        titleRes = R.string.layout_title_spartan_12,
                        layoutRes = R.raw.layout_spartan_12,
                    ),
                    Layout(
                        id = 13,
                        titleRes = R.string.layout_title_spartan_13,
                        layoutRes = R.raw.layout_spartan_13,
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
                ),
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_spartan_m_pro_01,
                        layoutRes = R.raw.layout_spartan_m_pro_01,
                    ),
                ),
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_v_system_01,
                        layoutRes = R.raw.layout_v_system_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_v_system_02,
                        layoutRes = R.raw.layout_v_system_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_v_system_03,
                        layoutRes = R.raw.layout_v_system_03,
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_econo_60_01,
                        layoutRes = R.raw.layout_econo_60_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_econo_60_02,
                        layoutRes = R.raw.layout_econo_60_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_econo_60_03,
                        layoutRes = R.raw.layout_econo_60_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_econo_60_04,
                        layoutRes = R.raw.layout_econo_60_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_econo_60_05,
                        layoutRes = R.raw.layout_econo_60_05,
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_pegasus_01,
                        layoutRes = R.raw.layout_pegasus_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_pegasus_02,
                        layoutRes = R.raw.layout_pegasus_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_pegasus_03,
                        layoutRes = R.raw.layout_pegasus_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_pegasus_04,
                        layoutRes = R.raw.layout_pegasus_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_pegasus_05,
                        layoutRes = R.raw.layout_pegasus_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_pegasus_06,
                        layoutRes = R.raw.layout_pegasus_06,
                    ),
                )
            ),
            Machine(
                id = 10,
                name = R.string.machine_autoBottom_name,
                brochure = R.raw.brochure_auto_bottom_erector,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_auto_bottom_erector_01,
                        layoutRes = R.raw.layout_auto_bottom_erector_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_auto_bottom_erector_02,
                        layoutRes = R.raw.layout_auto_bottom_erector_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_auto_bottom_erector_03,
                        layoutRes = R.raw.layout_auto_bottom_erector_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_auto_bottom_erector_04,
                        layoutRes = R.raw.layout_auto_bottom_erector_04,
                    ),
                )
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
                    ),
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_argo_01,
                        layoutRes = R.raw.layout_argo_01,
                    )
                )
            )
        )
    }
    /**
     * Gets the different trayformer machines
     *
     * Used in tandem with the [com.example.econoshow.ui.MachineTypesScreen] to display the correct info onto the
     * [com.example.econoshow.ui.MachinesScreen]
     *
     * @return The list of [Machine] for specifically trayformers.
     */
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_trayformer_01,
                        layoutRes = R.raw.layout_trayformer_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_trayformer_02,
                        layoutRes = R.raw.layout_trayformer_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_trayformer_03,
                        layoutRes = R.raw.layout_trayformer_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_trayformer_04,
                        layoutRes = R.raw.layout_trayformer_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_trayformer_05,
                        layoutRes = R.raw.layout_trayformer_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_trayformer_06,
                        layoutRes = R.raw.layout_trayformer_06,
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_trayformer_07,
                        layoutRes = R.raw.layout_trayformer_07,
                    ),
                    Layout(
                        id = 8,
                        titleRes = R.string.layout_title_trayformer_08,
                        layoutRes = R.raw.layout_trayformer_08,
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_reverse_triseal_01,
                        layoutRes = R.raw.layout_reverse_triseal_01
                    ),
                ),
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_t_system_01,
                        layoutRes = R.raw.layout_t_system_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_t_system_02,
                        layoutRes = R.raw.layout_t_system_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_t_system_03,
                        layoutRes = R.raw.layout_t_system_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_t_system_04,
                        layoutRes = R.raw.layout_t_system_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_t_system_05,
                        layoutRes = R.raw.layout_t_system_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_t_system_06,
                        layoutRes = R.raw.layout_t_system_06,
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_t_system_07,
                        layoutRes = R.raw.layout_t_system_07,
                    ),
                )
            )
        )
    }
    /**
     * Gets the different case packing machines
     *
     * Used in tandem with the [com.example.econoshow.ui.MachineTypesScreen] to display the correct info onto the
     * [com.example.econoshow.ui.MachinesScreen]
     *
     * @return The list of [Machine] for specifically case packers.
     */
    fun getCasepackingMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 15,
                name = R.string.machine_packer_name,
                brochure = R.raw.brochure_econopacker,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_econopacker_01,
                        layoutRes = R.raw.layout_econopacker_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_econopacker_02,
                        layoutRes = R.raw.layout_econopacker_02,
                    ),
                )
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
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_econocaser_01,
                        layoutRes = R.raw.layout_econocaser_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_econocaser_02,
                        layoutRes = R.raw.layout_econocaser_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_econocaser_03,
                        layoutRes = R.raw.layout_econocaser_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_econocaser_04,
                        layoutRes = R.raw.layout_econocaser_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_econocaser_05,
                        layoutRes = R.raw.layout_econocaser_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_econocaser_06,
                        layoutRes = R.raw.layout_econocaser_06,
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_econocaser_07,
                        layoutRes = R.raw.layout_econocaser_07,
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
    /**
     * Gets the different robot machines
     *
     * Used in tandem with the [com.example.econoshow.ui.MachineTypesScreen] to display the correct info onto the
     * [com.example.econoshow.ui.MachinesScreen]
     *
     * @return The list of [Machine] for specifically robots.
     */
    fun getRoboticsMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 18,
                name = R.string.machine_robot_palletizer,
                brochure = R.raw.brochure_palletizer,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_palletizer_01,
                        layoutRes = R.raw.layout_palletizer_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_palletizer_02,
                        layoutRes = R.raw.layout_palletizer_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_palletizer_03,
                        layoutRes = R.raw.layout_palletizer_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_palletizer_04,
                        layoutRes = R.raw.layout_palletizer_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_palletizer_05,
                        layoutRes = R.raw.layout_palletizer_05,
                    ),
                )
            ),
            Machine(
                id = 19,
                name = R.string.machine_robot_case_packer,
            ),
            Machine(
                id = 20,
                name = R.string.machine_robot_econobot,
                videos = listOf(
                    Video(
                        id = 1,
                        titleRes = R.string.video_title_robotics_sim_01,
                        videoRes = R.raw.robotics_sim_01
                    ),
                    Video(
                        id = 2,
                        titleRes = R.string.video_title_robotics_sim_02,
                        videoRes = R.raw.robotics_sim_02,
                    ),
                    Video(
                        id = 3,
                        titleRes = R.string.video_title_robotics_sim_03,
                        videoRes = R.raw.robotics_sim_03
                    )
                ),
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_robotic_01,
                        layoutRes = R.raw.layout_robotic_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_robotic_02,
                        layoutRes = R.raw.layout_robotic_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_robotic_03,
                        layoutRes = R.raw.layout_robotic_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_robotic_04,
                        layoutRes = R.raw.layout_robotic_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_robotic_05,
                        layoutRes = R.raw.layout_robotic_05,
                    ),
                )
            )
        )
    }
    /**
     * Gets the different beverage machines
     *
     * Used in tandem with the [com.example.econoshow.ui.MachineTypesScreen] to display the correct info onto the
     * [com.example.econoshow.ui.MachinesScreen]
     *
     * @return The list of [Machine] for specifically beverages.
     */
    fun getBeverageMachineData(): List<Machine> {
        return listOf(
            Machine(
                id = 21,
                name = R.string.machine_beverage_twinseal,
                brochure = R.raw.brochure_beverage_twinseal,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_beverage_twinseal_01,
                        layoutRes = R.raw.layout_beverage_twinseal_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_beverage_twinseal_02,
                        layoutRes = R.raw.layout_beverage_twinseal_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_beverage_twinseal_03,
                        layoutRes = R.raw.layout_beverage_twinseal_03,
                    ),
                )
            ),
            Machine(
                id = 22,
                name = R.string.machine_beverage_e_2000,
                brochure = R.raw.brochure_beverage_e_system_2000,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_beverage_e_2000_01,
                        layoutRes = R.raw.layout_beverage_e_2000_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_beverage_e_2000_02,
                        layoutRes = R.raw.layout_beverage_e_2000_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_beverage_e_2000_03,
                        layoutRes = R.raw.layout_beverage_e_2000_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_beverage_e_2000_04,
                        layoutRes = R.raw.layout_beverage_e_2000_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_beverage_e_2000_05,
                        layoutRes = R.raw.layout_beverage_e_2000_05,
                    ),
                    Layout(
                        id = 6,
                        titleRes = R.string.layout_title_beverage_e_2000_06,
                        layoutRes = R.raw.layout_beverage_e_2000_06,
                    ),
                    Layout(
                        id = 7,
                        titleRes = R.string.layout_title_beverage_e_2000_07,
                        layoutRes = R.raw.layout_beverage_e_2000_07,
                    ),
                    Layout(
                        id = 8,
                        titleRes = R.string.layout_title_beverage_e_2000_08,
                        layoutRes = R.raw.layout_beverage_e_2000_08,
                    ),
                    Layout(
                        id = 9,
                        titleRes = R.string.layout_title_beverage_e_2000_09,
                        layoutRes = R.raw.layout_beverage_e_2000_09,
                    ),
                )
            ),
            Machine(
                id = 23,
                name = R.string.machine_beverage_spartan,
                brochure = R.raw.brochure_beverage_spartan,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_beverage_spartan_01,
                        layoutRes = R.raw.layout_beverage_spartan_01,
                    ),
                    Layout(
                        id = 2,
                        titleRes = R.string.layout_title_beverage_spartan_02,
                        layoutRes = R.raw.layout_beverage_spartan_02,
                    ),
                    Layout(
                        id = 3,
                        titleRes = R.string.layout_title_beverage_spartan_03,
                        layoutRes = R.raw.layout_beverage_spartan_03,
                    ),
                    Layout(
                        id = 4,
                        titleRes = R.string.layout_title_beverage_spartan_04,
                        layoutRes = R.raw.layout_beverage_spartan_04,
                    ),
                    Layout(
                        id = 5,
                        titleRes = R.string.layout_title_beverage_spartan_05,
                        layoutRes = R.raw.layout_beverage_spartan_05,
                    ),
                )
            ),
            Machine(
                id = 24,
                name = R.string.machine_beverage_trayformer,
                layouts = listOf(
                    Layout(
                        id = 1,
                        titleRes = R.string.layout_title_beverage_trayformer_01,
                        layoutRes = R.raw.layout_beverage_trayformer_01
                    )
                )
            )
        )
    }
}