package id.ajiguna.gmailclonecompose.model

data class Account(
    val icon: Int? = null,
    val userName: String,
    val email: String,
    val unReadMails: Int
)
