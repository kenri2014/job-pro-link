export const constantRoute = [
    // 登録
    {
        path: '/login',
        component: () => import('@/views/login/index.vue'),
        name: 'login',
        meta: {
            title: '登录',
            hidden: true,
        },
    },
    {
        path: '/',
        component: () => import('@/views/home/index.vue'),
        name: 'layout',
        meta: {
            title: '',
            hidden: false,
        },
    },
    {
        path: '/404',
        component: () => import('@/views/404/index.vue'),
        meta: {
            title: '404',
            hidden: true,
        },
    },
    {
        path: '/:pathMatch(.*)',
        redirect: '/404',
        name: 'any',
    },
    {
        path: '/register/talent',
        component: () => import('@/views/register/talentRegister.vue'),
        name: 'talentRegister'
    },
    {
        path: '/register/company',
        component: () => import('@/views/register/companyRegister.vue'),
        name: 'companyRegister'
    },
    {
        //  ユーザー登録成功後のデータ表示ルーティング
        path: '/showcase/talent/:talentId',
        component: () => import('@/views/talentShowcase.vue'),
        name: 'talentShowcase'
    }
]
