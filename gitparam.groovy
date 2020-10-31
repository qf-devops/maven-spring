def getbranches = "git ls-remote -h -t https://github.com/quickfixsoln/springexample.git".execute()
def branches = []
def b1 = []
getbranches.text.eachLine {branches.add(it)}
for(i in branches)
b1.add(i.split()[1].replaceAll('\\^\\{\\}', '').replaceAll('refs/tags/', '').replaceAll('refs/heads/', ''))
b1 = b1.unique()
return b1


def getbranches = "git ls-remote -h -t https://github.com/quickfixsoln/springexample.git".execute()
def branches = []
def b1 = []
getbranches.text.eachLine {branches.add(it)}
for(i in branches)
b1.add(i.split()[1].replaceAll('\\^\\{\\}', '').replaceAll('refs/tags/', '').replaceAll('refs/heads/', ''))
b1 = b1.unique()
return b1




import groovy.json.JsonSlurperClassic
import jenkins.model.Jenkins


creds = getCredentials()

def getCredentials() {
    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
    com.cloudbees.plugins.credentials.common.StandardUsernameCredentials.class,
    Jenkins.instance,
    null,
    null)
    for (c in creds) {
    if (c.id == "CREDENTIALS_ID") {
        user = c.username
        pass = c.password
    }
    }
    def credentials = "${user}:${pass}"
    return credentials.toString()
} 
sn = 'git ls-remote -h -t https://'+creds+'@bitbucket.org/devopsmar12019/'+servicename+'.git'
def getbranches = sn.execute()
def branches = []
def b1 = []
getbranches.text.eachLine {branches.add(it)}
for(i in branches)
b1.add(i.split()[1].replaceAll('\\^\\{\\}', '').replaceAll('refs/tags/', '').replaceAll('refs/heads/', ''))
b1 = b1.unique()
return b1



--------------
  
  Active Choices Parameter
  Active Choices Reactive Parameter
