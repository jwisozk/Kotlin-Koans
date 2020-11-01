fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    if (message == null)
        return
    client?.personalInfo?.email?.let {
        mailer.sendMessage(it, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
