package com.example.econoshow.ui

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.econoshow.R
import com.example.econoshow.data.LocalEconoShowDataProvider
import com.example.econoshow.utils.AfkController
import com.example.econoshow.utils.EconoShowContentType
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

enum class EconoShowScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    MachineTypes(title = R.string.screen_machineTypes),
    Machines(title = R.string.screen_machines),
    Information(title = R.string.screen_perMachine),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EconoShowAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    currentScreen: EconoShowScreen,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center,

            ) {
                Text(
                    text = stringResource(currentScreen.title),
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp)
                    )
                }
            },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        modifier = modifier
            .height(dimensionResource(R.dimen.top_bar_height)),
        navigationIcon = {
            if (canNavigateBack) {
                Button(
                    onClick = navigateUp
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.top_bar_height)),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    )
}

@Composable
fun EconoShowApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val viewModel: EconoShowViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = EconoShowScreen.valueOf(
        backStackEntry?.destination?.route ?: EconoShowScreen.Home.name
    )

    val coroutineScope = rememberCoroutineScope()

    val contentType: EconoShowContentType

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = EconoShowContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            contentType = EconoShowContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = EconoShowContentType.LIST_AND_DETAIL
        }
        else -> {
            contentType = EconoShowContentType.LIST_ONLY
        }
    }

    Scaffold (
        topBar = {
            if (currentScreen != EconoShowScreen.Home) {
                EconoShowAppBar(
                    canNavigateBack = navController.previousBackStackEntry != null,
                    currentScreen = currentScreen,
                    navigateUp = {
                        if (currentScreen == EconoShowScreen.MachineTypes) {
                            uiState.afkTimer?.cancel()
                        }
                        navController.navigateUp() }
                )
            }
        }
    ) {
        innerPadding ->

        NavHost(
            navController = navController,
            startDestination = EconoShowScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            /**
             * HomeScreen: Prepares the user to enter into the app and catch viewers attention
             */
            composable(
                route = EconoShowScreen.Home.name
            ) {
                HomeScreen(
                    onAnywhereClick = {
                        navController.navigate(EconoShowScreen.MachineTypes.name)
                        viewModel.setAfkTimerJob(afkTimer = coroutineScope.launch {
                            AfkController.startTimer(
                                finishAndWait = {
                                    navController.navigate(EconoShowScreen.Home.name)
                                }
                            )
                        })
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            /**
             * MachineTypes: Displays different type of machines
             */
            composable(
                route = EconoShowScreen.MachineTypes.name,
                enterTransition = {
                    when (initialState.destination.route) {
                        EconoShowScreen.Machines.name ->
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                exitTransition = {
                    when (targetState.destination.route) {
                        EconoShowScreen.Machines.name ->
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popEnterTransition = {
                    when (initialState.destination.route) {
                        EconoShowScreen.Machines.name ->
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popExitTransition = {
                    when (initialState.destination.route) {
                        EconoShowScreen.Machines.name ->
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                }) {
                MachineTypesScreen(
                    machineTypes = LocalEconoShowDataProvider.getMachineTypeData(),
                    onMachineTypeButtonClicked = {
                        viewModel.setMachineType(it)
                        navController.navigate(EconoShowScreen.Machines.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            /**
             * Machines: Displays different types of machines based on chosen machine type
             */
            composable(
                route = EconoShowScreen.Machines.name,
                enterTransition = {
                    when (initialState.destination.route) {
                        EconoShowScreen.MachineTypes.name ->
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                exitTransition = {
                    when (targetState.destination.route) {
                        EconoShowScreen.MachineTypes.name ->
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popEnterTransition = {
                    when (initialState.destination.route) {
                        EconoShowScreen.MachineTypes.name ->
                            slideIntoContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                },
                popExitTransition = {
                    when (targetState.destination.route) {
                        EconoShowScreen.MachineTypes.name ->
                            slideOutOfContainer(
                                AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(700)
                            )
                        else -> null
                    }
                }) {
                MachinesScreen(
                    machines =
                        when(uiState.currentMachineType.id) {
                            1 -> LocalEconoShowDataProvider.getCartonerMachineData()
                            2 -> LocalEconoShowDataProvider.getTrayformerMachineData()
                            3 -> LocalEconoShowDataProvider.getCasepackingMachineData()
                            4 -> LocalEconoShowDataProvider.getRoboticsMachineData()
                            else -> LocalEconoShowDataProvider.getCartonerMachineData()
                        },
                    onMachineButtonClicked = {
                        viewModel.setMachine(it)
                        navController.navigate(EconoShowScreen.Information.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            /**
             * Information: Displays a common screen that lists the different types of information
             * available per machine
             */
            composable(route = EconoShowScreen.Information.name) {
                InformationScreen(
                    machine = uiState.currentMachine,
                    subScreenIndex = uiState.currentInformationSubScreenIndex,
                    onSegmentedButtonClick = {
                        viewModel.setCurrentInformationSubScreenIndex(it)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}