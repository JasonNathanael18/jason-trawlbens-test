package dependencies
import core.Dependencies

internal val androidComposeDependencies = listOf(
    Dependencies.coreKtx,
    Dependencies.composeMaterial,
    Dependencies.composeActivity,
    Dependencies.composeUi,
    Dependencies.composePreviewUi,
    Dependencies.composeNavigation
)

internal val androidUiDependencies = listOf(
    Dependencies.appcompat,
    Dependencies.material,
    Dependencies.constraintLayout,
    Dependencies.navigationFragment,
    Dependencies.navigationUi,
    Dependencies.fragment
)

internal val androidxLifeCycleDependencies = listOf(
    //Dependencies.viewModel,
    Dependencies.liveData,
    //Dependencies.runtimeCompose,
    Dependencies.viewModelSaveState,
    Dependencies.lifecycleService,
)

internal val coroutinesAndroidDependencies = listOf(
    Dependencies.kotlinCoroutines,
    Dependencies.moshiConverter
)

internal val coilImageLoadingDependencies = listOf(
    Dependencies.coil,
)

internal val networkDependencies = listOf(
    Dependencies.retrofit,
    Dependencies.retrofitGsonConverter,
    Dependencies.gson,
    Dependencies.okhHttp3,
    Dependencies.okhHttp3Interceptor,
    Dependencies.rxJava3adapter,
)



