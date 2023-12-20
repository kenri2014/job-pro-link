const talentList = [{
    userId: 1,
    id: '@id',
    avatar:
        'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    email: 'admin@gmail.com',
    password: '111111',
    desc: '平台管理员',
    roles: ['平台管理员'],
    buttons: ['cuser.detail'],
    routes: ['home'],
    token: 'Admin Token',
},
{
    userId: 2,
    avatar:
        'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
    email: 'system',
    password: '111111',
    desc: '系统管理员',
    roles: ['系统管理员'],
    buttons: ['cuser.detail', 'cuser.user'],
    routes: ['home'],
    token: 'System Token',
},]

function createUserList() {
    return talentList;
}


export default [

    {
        url: '/user/login',
        method: 'post',
        response: ({ body }) => {
            const { email, password } = body;
            const checkUser = createUserList().find(
                (item) => item.email === email && item.password === password,
            )
            if (!checkUser) {
                return { code: 201, data: { message: 'IDやパスワードが違っている。' } }
            }
            const { token } = checkUser
            return { code: 200, data: { token } }
        },
    },

    {
        url: '/user/info',
        method: 'get',
        response: (request) => {
            const token = request.headers.token;
            const checkUser = createUserList().find((item) => item.token === token)
            if (!checkUser) {
                return { code: 201, data: { message: '获取用户信息失败' } }
            }
            return { code: 200, data: { checkUser } }
        },
    },
]
