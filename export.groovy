// API not usually deployed to prevent DOS Attack
def apiUrl = "http://www.minedme.com/api/social/activity/v100/user/wes/network/all/date/"

def exportFolder = "C:\\Users\\wes\\workspace\\socialData\\export\\"
def dateFormat = "yyyyMMdd"
def nextDate = new Date().minus(1)
def formattedDate = nextDate.format(dateFormat)

while(formattedDate >= "20110701") {
  def nextFile = new File(exportFolder + "all" + formattedDate + ".json")

  if(nextFile.exists()) {
    break;
  }

  def url = new URL(apiUrl + formattedDate)
  nextFile.text = url.text

  Thread.sleep(2000)
  nextDate = nextDate.minus(1)
  formattedDate = nextDate.format(dateFormat) 
}
