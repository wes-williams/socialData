import groovy.json.JsonSlurper

def slurper = new JsonSlurper()

def exportFolder = "C:\\Users\\wes\\workspace\\socialData\\export\\"
def noActivity=0
def missingActivity=0
def allActivity=0
def foundActivity=0
def sumActivity=0
def fileCount=0

new File(exportFolder).eachFile { f ->

  def activity = slurper.parseText(f.text)
  switch(activity.size()) {
    case 0:
      noActivity++
      break
    case 4:
      allActivity++
      break
    default:
      missingActivity++
      break
  }

  def thisActivity = activity.sum { o -> o.count }
  if(thisActivity > 0) {
    foundActivity++
    sumActivity += thisActivity
  }

  fileCount++
}

println "Activity File Count:    ${fileCount}"
println "No Activity Count:      ${noActivity}"
println "Missing Activity Count: ${missingActivity}"
println "All Activity Count:     ${allActivity}"
println "Days of Activity:       ${foundActivity}"
println "Sum of Activity:        ${sumActivity}"