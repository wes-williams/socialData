import groovy.json.JsonSlurper

def exportFolder = "C:\\Users\\wes\\workspace\\socialData\\export\\"
def flattenFile = "C:\\Users\\wes\\workspace\\socialData\\flatten\\all.txt"

def networks = ["facebook","twitter","linkedin","foursquare"]
def slurper = new JsonSlurper()

def fileText = new StringBuilder()
fileText.append("date")
networks.each { fileText.append(",${it}") }
fileText.append("\r\n")

new File(exportFolder).eachFile { f ->
 
  def dateOfFile = f.name - "all" -".json"
  def activities = slurper.parseText(f.text)

  fileText.append("${dateOfFile}")
  networks.each { n ->
    def networkActivity = activities.find { it.network == n }

    def activityCount=0;
    if(networkActivity!=null) {
      activityCount = networkActivity.count  
    }

    fileText.append(",${activityCount}")
  }
  
  fileText.append("\r\n")
}

new File(flattenFile).text = fileText.toString()

