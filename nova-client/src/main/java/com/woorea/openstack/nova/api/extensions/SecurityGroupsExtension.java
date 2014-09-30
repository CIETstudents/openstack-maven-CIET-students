package com.woorea.openstack.nova.api.extensions;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.SecurityGroup;
import com.woorea.openstack.nova.model.SecurityGroupForCreate;
import com.woorea.openstack.nova.model.SecurityGroupRuleForCreate;
import com.woorea.openstack.nova.model.SecurityGroups;

/**
 * @author govindon.
 */
public class SecurityGroupsExtension {

    /**
     * The instance is created for the OpenStackClient class.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the SecurityGroupsExtension class.
     *
     * @param client the client to set
     */
    public SecurityGroupsExtension(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * The class List extends the SecurityGroups class from the Nova Model.
     */
    public class List extends OpenStackRequest<SecurityGroups> {

        /**
         * Get the list.
         */
        public List() {
            super(CLIENT, HttpMethod.GET, "/os-security-groups", null,
                    SecurityGroups.class);
        }
    }

    /**
     * The Create class extends the SecurityGroup class from the Nova Model.
     */
    public class Create extends OpenStackRequest<SecurityGroup> {

        /**
         * The instance is created for the SecurityGroupForCreate class.
         */
        private SecurityGroupForCreate securityGroupForCreate;

        /**
         * The created instance is used to access the Create class.
         *
         * @param securityGroupForCreate the securityGroupForCreate to set
         */
        public Create(SecurityGroupForCreate securityGroupForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-security-groups",
                    Entity.json(securityGroupForCreate), SecurityGroup.class);
            this.securityGroupForCreate = securityGroupForCreate;
        }

    }

    /**
     * The class Show extends the SecurityGroup class from the Nova Model.
     */
    public class Show extends OpenStackRequest< SecurityGroup> {

        /**
         * Shows the List.
         *
         * @deprecated @param id
         */
        public Show(Integer id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuilder("/os-security-groups/").append(id).
                    toString(), null, SecurityGroup.class);
        }

        /**
         * Get the list.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuilder("/os-security-groups/").append(id).
                    toString(), null, SecurityGroup.class);
        }

    }

    /**
     * The Delete class extends the OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest< Void> {

        /**
         * Delete the identifier.
         *
         * @param id the id to set
         * @deprecated Delete
         */
        public Delete(Integer id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/os-security-groups/")
                    .append(String.valueOf(id)).toString(), null,
                    Void.class);
        }

        /**
         * Delete the id.
         *
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/os-security-groups/").append(id).
                    toString(), null, Void.class);
        }

    }

    /**
     * The class CreateRule extends the SecurityGroup.Ruke
     */
    public class CreateRule extends OpenStackRequest<SecurityGroup.Rule> {

        /**
         * Instance is created for the SecurityGroupRuleForCreate class.
         */
        private SecurityGroupRuleForCreate securityGroupRuleForCreate;

        /**
         * The created Instance is used to access the CreateRule method.
         *
         * @param securityGroupRuleForCreate the securityGroupRuleForCreate to
         * set
         */
        public CreateRule(SecurityGroupRuleForCreate securityGroupRuleForCreate) {
            super(CLIENT, HttpMethod.POST, "/os-security-group-rules",
                    Entity.json(securityGroupRuleForCreate),
                    SecurityGroup.Rule.class);
            this.securityGroupRuleForCreate = securityGroupRuleForCreate;
        }
    }

    /**
     * The DeleteRule extends the OpenStackRequest class.
     */
    public class DeleteRule extends OpenStackRequest<Void> {

        /**
         * @param id the id to set
         * @deprecated
         */
        public DeleteRule(Integer id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/os-security-group-rules/")
                    .append(String.valueOf(id)).toString(), null,
                    Void.class);
        }

        /**
         * The DeleteRule deletes the identifier.
         *
         * @param id the id to set
         */
        public DeleteRule(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/os-security-group-rules/")
                    .append(String.valueOf(id)).toString(), null,
                    Void.class);
        }
    }

    /**
     * @return the list
     */
    public List listSecurityGroups() {
        return new List();
    }

    /**
     * Instance is created for the Create class.
     *
     * @param name the name to set
     * @param description the description to set
     * @return the created list
     */
    public Create createSecurityGroup(String name,
            String description) {
        return new Create(new SecurityGroupForCreate(name, description));
    }

    /**
     * Instance is created for the Create class.
     *
     * @param name the name to set
     * @return the createSecurityGroup name
     */
    public Create createSecurityGroup(String name) {
        return createSecurityGroup(name, null);
    }

    /**
     * Instance is created for the Show class.
     *
     * @param id the id to set
     * @return the Show
     */
    public Show showSecurityGroup(Integer id) {
        return new Show(String.valueOf(id));
    }

    /**
     * Instance is created for the Show class.
     *
     * @param id the id to set
     * @return the id
     */
    public Show showSecurityGroup(String id) {
        return new Show(id);
    }

    /**
     * Instance is created for the Delete class.
     *
     * @param id the id to set
     * @return the valueOf id
     */
    public Delete deleteSecurityGroup(Integer id) {
        return new Delete(String.valueOf(id));
    }

    /**
     * The instance is created for the Delete class.
     *
     * @param id the id to set
     * @return the id
     */
    public Delete deleteSecurityGroup(String id) {
        return new Delete(id);
    }

    /**
     * The instance is created for the CreatedRule class.
     *
     * @param parentSecurityGroupId the parentSecurityGroupId to set
     * @param ipProtocol the ipProtocol to set
     * @param fromPort the fromPort to set
     * @param toPort the toPort to set
     * @param cidr the cidr to set
     * @return the Created Rule
     * @deprecated Use
     * {@link #createSecurityGroupRule(String, String, Integer, Integer, String)}
     */
    public CreateRule createSecurityGroupRule(
            Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
            Integer toPort, String cidr) {
        SecurityGroupRuleForCreate securityGroupRuleForCreate
                = new SecurityGroupRuleForCreate(
                        parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
        return new CreateRule(securityGroupRuleForCreate);
    }

    /**
     * The instance is created for the CreateRule class.
     *
     * @param parentSecurityGroupId the parentSecurityGroupId to set
     * @param ipProtocol the ipProtocol to set
     * @param fromPort the fromPort to set
     * @param toPort the toPort to set
     * @param sourceGroupId the sourceGroupId to set
     * @return the Created rRle
     * @deprecated Use
     * {@link #createSecurityGroupRule(String, String, String, Integer, Integer)}
     */
    public CreateRule createSecurityGroupRule(
            Integer parentSecurityGroupId, String ipProtocol, Integer fromPort,
            Integer toPort, Integer sourceGroupId) {
        SecurityGroupRuleForCreate securityGroupRuleForCreate
                = new SecurityGroupRuleForCreate(
                        parentSecurityGroupId, ipProtocol, fromPort, toPort,
                        sourceGroupId);
        return new CreateRule(securityGroupRuleForCreate);
    }

    /**
     * The instance is created for the CreateRule class.
     *
     * @param parentSecurityGroupId the parentSecurityGroupId to set
     * @param ipProtocol the ipProtocol to set
     * @param fromPort the fromPort to set
     * @param toPort the toPort to set
     * @param cidr the cidr to set
     * @return the CreateRule
     */
    public CreateRule createSecurityGroupRule(
            String parentSecurityGroupId, String ipProtocol, Integer fromPort,
            Integer toPort, String cidr) {
        SecurityGroupRuleForCreate securityGroupRuleForCreate
                = new SecurityGroupRuleForCreate(
                        parentSecurityGroupId, ipProtocol, fromPort, toPort, cidr);
        return new CreateRule(securityGroupRuleForCreate);
    }

    /**
     * The instance is created for the CreateRule class.
     *
     * @param parentSecurityGroupId the parentSecurityGroupId to set
     * @param sourceGroupId the sourceGroupId to set
     * @param ipProtocol the ipProtocol to set
     * @param fromPort the fromPort to set
     * @param toPort the toPort to set
     * @return the CreateRule
     */
    public CreateRule createSecurityGroupRule(
            String parentSecurityGroupId, String sourceGroupId,
            String ipProtocol, Integer fromPort, Integer toPort) {
        SecurityGroupRuleForCreate securityGroupRuleForCreate
                = new SecurityGroupRuleForCreate(parentSecurityGroupId,
                        sourceGroupId, ipProtocol, fromPort, toPort);
        return new CreateRule(securityGroupRuleForCreate);
    }

    /**
     * The instance is created for the DeleteRule class.
     *
     * @param id the id to set
     * @return the identifier
     */
    public DeleteRule deleteSecurityGroupRule(String id) {
        return new DeleteRule(id);
    }

    /**
     * The instance is created for the DeleteRule class.
     *
     * @param id the id to set
     * @return the valueOf identifier
     */
    public DeleteRule deleteSecurityGroupRule(Integer id) {
        return new DeleteRule(String.valueOf(id));
    }
}
