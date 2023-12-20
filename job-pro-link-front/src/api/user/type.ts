
export interface LoginFormData {
    email?: string
    password?: string
}

export interface dataType {
    token?: string,
    message?: string
}

export interface LoginResponseData {
    code: string
    data: { token: string }
    message?: string
}



export interface UserInfoResponseData {
    code: number
    data: {
        userId: number,
        username: string,
        password: string,
        desc: string,
        routes: string[]
        buttons: string[]
        roles: string[]
        avatar: string
        token: string
    }
}

export interface TalentRegisterData {
    icon?: string
    userName?: string
    password?: string
    email?: string
    birthday?: string
    genderKbn?: string
    mobilePhone?: string
    countryKbn?: string
    address?: string
    educationKbn?: string
    specialty?: string
    admisissionDate?: string
    school?: string
    graduationDate?: string
}

export interface RegisterResponseData {
    message?: string
    code: string
    data?: string
}

export interface TalentInfoResponseData {
    code: number
    data: {
        imageUrl?: string
        username?: string
        password?: string
        email?: string
        birthdate?: string
        gender?: string
        telephone?: string
        country?: string
        address?: string
        degree?: string
        major?: string
        admisissionDate?: string
        school?: string
        graduationDate?: string
    }
}


export interface NameRuleResponseData {
    message?: string
    data?: string
    code: string
}


export interface PasswordRuleResponseData {
    message?: string
    data?: string
    code: string
}
