package nine.dawa

import grails.core.GrailsApplication
import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Shared
import spock.lang.Specification

@Integration
class DawaLiveIntegrationSpec extends Specification {

     @Autowired
    DawaService dawaService

    @Autowired
    GrailsApplication grailsApplication

    def "test rest response"() {
        when:
            def response = dawaService.getRegioner()
        then:
            with(response.first()) {
                kode == '1081'
                navn == 'Region Nordjylland'
                href == 'https://dawa.aws.dk/regioner/1081'
            }

    }

}
