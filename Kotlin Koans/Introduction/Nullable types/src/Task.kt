fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    var email=client?.personalInfo?.email
    if (message != null) {
        if (email != null) {
            mailer.sendMessage(email,message)
        }
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}
