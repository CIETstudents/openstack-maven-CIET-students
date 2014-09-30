package com.woorea.openstack.nova.api;

import java.util.Map;

import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.Metadata;
import com.woorea.openstack.nova.model.Server;
import com.woorea.openstack.nova.model.Server.Addresses;
import com.woorea.openstack.nova.model.ServerAction.ChangePassword;
import com.woorea.openstack.nova.model.ServerAction.ConfirmResize;
import com.woorea.openstack.nova.model.ServerAction.ConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.CreateBackup;
import com.woorea.openstack.nova.model.ServerAction.CreateImage;
import com.woorea.openstack.nova.model.ServerAction.GetConsoleOutput;
import com.woorea.openstack.nova.model.ServerAction.GetVncConsole;
import com.woorea.openstack.nova.model.ServerAction.Lock;
import com.woorea.openstack.nova.model.ServerAction.Pause;
import com.woorea.openstack.nova.model.ServerAction.Reboot;
import com.woorea.openstack.nova.model.ServerAction.Rebuild;
import com.woorea.openstack.nova.model.ServerAction.Rescue;
import com.woorea.openstack.nova.model.ServerAction.Resize;
import com.woorea.openstack.nova.model.ServerAction.Resume;
import com.woorea.openstack.nova.model.ServerAction.RevertResize;
import com.woorea.openstack.nova.model.ServerAction.Start;
import com.woorea.openstack.nova.model.ServerAction.Stop;
import com.woorea.openstack.nova.model.ServerAction.Suspend;
import com.woorea.openstack.nova.model.ServerAction.Unlock;
import com.woorea.openstack.nova.model.ServerAction.Unpause;
import com.woorea.openstack.nova.model.ServerAction.Unrescue;
import com.woorea.openstack.nova.model.ServerAction.VncConsole;
import com.woorea.openstack.nova.model.ServerForCreate;
import com.woorea.openstack.nova.model.Servers;
import com.woorea.openstack.nova.model.VolumeAttachment;
import com.woorea.openstack.nova.model.VolumeAttachments;

/**
 * @author govindon.
 *
 * The class ServersResource.
 */
public class ServersResource {

    /**
     * The instance is created for the OpenStackClient.
     */
    private final OpenStackClient CLIENT;

    /**
     * The created instance is used to access the ServersResource class.
     *
     * @param client the client to set
     */
    public ServersResource(OpenStackClient client) {
        CLIENT = client;
    }

    /**
     * The instance is created for the List class.
     *
     * @param detail the detail to set
     * @return the List of detail
     */
    public List list(boolean detail) {
        return new List(detail);
    }

    /**
     * The instance is created for the Boot class.
     *
     * @param server the server to set
     * @return the Boot
     */
    public Boot boot(ServerForCreate server) {
        return new Boot(server);
    }

    /**
     * The instance is created for the Show class.
     *
     * @param id the id to set
     * @return the Show
     */
    public Show show(String id) {
        return new Show(id);
    }

    /**
     * The instance is created for the ShowMetadata class.
     *
     * @param id the id to set
     * @return the ShowMetadata
     */
    public ShowMetadata showMetadata(String id) {
        return new ShowMetadata(id);
    }

    /**
     * The instance is created for the CreateOrUpdateMetadata class.
     *
     * @param id the id to set
     * @param metadata the metadata to set
     * @return the CreateOrUpdateMetadata
     */
    public CreateOrUpdateMetadata createOrUpdateMetadata(String id,
            Metadata metadata) {
        return new CreateOrUpdateMetadata(id, metadata);
    }

    /**
     * The instance is created for the ReplaceMetadata class.
     *
     * @param id the id to set
     * @param metadata the metadata to set
     * @return the ReplaceMetadata
     */
    public ReplaceMetadata replaceMetadata(String id, Metadata metadata) {
        return new ReplaceMetadata(id, metadata);
    }

    /**
     * The instance is created for the DeleteMetadata class.
     *
     * @param id the id to set
     * @param key the key to set
     * @return the DeleteMetadata
     */
    public DeleteMetadata deleteMetadata(String id, String key) {
        return new DeleteMetadata(id, key);
    }

    /**
     * The instance is created for the Delete class.
     *
     * @param id the id to set
     * @return the Delete
     */
    public Delete delete(String id) {
        return new Delete(id);
    }

    /**
     * The class List extends the Servers class from the Nova Model.
     */
    public class List extends OpenStackRequest<Servers> {

        /**
         * GET the List.
         *
         * @param detail the detail to set
         */
        public List(boolean detail) {
            super(CLIENT, HttpMethod.GET, detail ? "/servers/detail"
                    : "/servers", null, Servers.class);
        }

    }

    /**
     * The class Boot extends the Server class from the Nova Model.
     */
    public class Boot extends OpenStackRequest<Server> {

        /**
         * The instance is created for the ServerForCreate class.
         */
        private ServerForCreate server;

        /**
         * The created instance is used to access the Boot class.
         *
         * @param server the server to set
         */
        public Boot(ServerForCreate server) {
            super(CLIENT, HttpMethod.POST, "/servers",
                    Entity.json(server), Server.class);
            this.server = server;
        }

    }

    /**
     * The class Show extends the Server class from the Nova Model.
     */
    public class Show extends OpenStackRequest<Server> {

        /**
         * GET the id.
         *
         * @param id the id to set
         */
        public Show(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuilder("/servers/").append(id), null,
                    Server.class);
        }

    }

    /**
     * The class ShowMetadata extends the Metadata class from the Nova Model.
     */
    public class ShowMetadata extends OpenStackRequest<Metadata> {

        /**
         * GET the id.
         *
         * @param id the id to set
         */
        public ShowMetadata(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuilder("/servers/").append(id)
                    .append("/metadata"), null, Metadata.class);
        }

    }

    /**
     * The class CreateOrUpdateMetadata extends the Metadata class from the Nova
     * Model.
     */
    public class CreateOrUpdateMetadata extends OpenStackRequest<Metadata> {

        /**
         * The instance of Metadata is used to access the CreateOrUpdateMetadata
         * class.
         *
         * @param id the id to set
         * @param metadata the metadata to set
         */
        public CreateOrUpdateMetadata(String id, Metadata metadata) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id).
                    append("/metadata"),
                    Entity.json(metadata), Metadata.class);
        }

    }

    /**
     * The class ReplaceMetadata extends the Metadata class from the Nova Model.
     */
    public class ReplaceMetadata extends OpenStackRequest<Metadata> {

        /**
         * The instance of Metadata is used to access the ReplaceMetadata class.
         *
         * @param id the id to set
         * @param metadata the metadata to set
         */
        public ReplaceMetadata(String id, Metadata metadata) {
            super(CLIENT, HttpMethod.PUT,
                    new StringBuilder("/servers/").append(id)
                    .append("/metadata"),
                    Entity.json(metadata), Metadata.class);
        }

    }

    /**
     * The class DeleteMetadata extends the OpenStackReuqest class.
     */
    public class DeleteMetadata extends OpenStackRequest<Void> {

        /**
         * GET the id and key.
         *
         * @param id the id to set
         * @param key the key to set
         */
        public DeleteMetadata(String id, String key) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/servers/").append(id).
                    append("/metadata/").append(key), null,
                    Void.class);
        }

    }

    /**
     * The class Delete extends the OpenStackRequest class.
     */
    public class Delete extends OpenStackRequest<Void> {

        /**
         * @param id the id to set
         */
        public Delete(String id) {
            super(CLIENT, HttpMethod.DELETE,
                    new StringBuilder("/servers/").append(id), null,
                    Void.class);
        }

    }

    /**
     * The class SHowServerAddresses extends the Addresses class from the Nova
     * Model.
     */
    public class ShowServerAddresses extends OpenStackRequest<Addresses> {

        /**
         * GET the id.
         *
         * @param id the id to set
         */
        public ShowServerAddresses(String id) {
            super(CLIENT, HttpMethod.GET,
                    new StringBuilder("/servers/").append(id)
                    .append("/ips"), null, Addresses.class);
        }

    }

    /**
     * The class UpdateServer extends the Server class from the Nova Model.
     */
    public class UpdateServer extends OpenStackRequest<Server> {

        /**
         * The instance is created for the Server class.
         */
        private final Server server;

        /**
         * The created instance is used to access the UpdateServer class.
         *
         * @param id the id to set
         * @param server the server to set
         */
        public UpdateServer(String id, Server server) {
            super(CLIENT, HttpMethod.PUT,
                    new StringBuilder("/servers/").append(id),
                    Entity.json(server), Server.class);
            this.server = server;
        }

    }

    /**
     * The instance is created for the UpdateServer class..
     *
     * @param serverId the serverId to set
     * @param name the name to set
     * @param accessIPv4 the accessIPv4 to set
     * @param accessIPv6 the accessIPv6 to set
     * @return
     */
    public UpdateServer update(String serverId, String name,
            String accessIPv4, String accessIPv6) {
        Server server = new Server();
        //server.setName(name);
        //server.setAccessIPv4(accessIPv4);
        //server.setAccessIPv6(accessIPv6);
        return new UpdateServer(serverId, server);
    }

    /**
     * The class Action extends the OpenStackRequest class.
     *
     * @param <T>
     */
    public abstract class Action<T> extends OpenStackRequest<T> {

        /**
         * POST the id, entity and returnType.
         *
         * @param id the id to set
         * @param entity the entity to set
         * @param returnType the returnType to set
         */
        public Action(String id, Entity<?> entity, Class< T> returnType) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"), entity, returnType);
        }

    }

    /**
     * The class ChangePasswordAction extends the Server class from the Nova
     * Model.
     */
    public class ChangePasswordAction extends Action<Server> {

        /**
         * The instance is created for the ChangePassword class.
         */
        private ChangePassword action;

        /**
         * The created instance is used to access the ChangePasswordAction
         * class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public ChangePasswordAction(String id, ChangePassword action) {
            super(id, Entity.json(action), Server.class);
        }

    }

    /**
     * The instance is created for the ChangePasswordAction class.
     *
     * @param serverId the serverId to set
     * @param adminPass the adminPass to set
     * @return the ChangePasswordAction
     */
    public ChangePasswordAction changePassword(String serverId,
            String adminPass) {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setAdminPass(adminPass);
        return new ChangePasswordAction(serverId, changePassword);
    }

    /**
     * The class RebootAction extends the Action class.
     */
    public class RebootAction extends Action<Void> {

        /**
         * The instance is created for the Reboot class.
         */
        private Reboot action;

        /**
         * The created instance is used to access the RebootAction class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public RebootAction(String id, Reboot action) {
            super(id, Entity.json(action), Void.class);
        }

    }

    /**
     * The instance is created for the RebootAction class.
     *
     * @param serverId the serverId to set
     * @param rebootType the rebootType to set
     * @return the RebootAction
     */
    public RebootAction reboot(String serverId, String rebootType) {
        Reboot reboot = new Reboot();
        reboot.setType(rebootType);
        return new RebootAction(serverId, reboot);
    }

    /**
     * The class RebuildAction extends the Server class from the Nova Model.
     */
    public class RebuildAction extends Action<Server> {

        /**
         * The instance is created for the Rebuild class.
         */
        private Rebuild action;

        /**
         * The created instance is used to access the RebuildAction.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public RebuildAction(String id, Rebuild action) {
            super(id, Entity.json(action), Server.class);
        }

    }

    /**
     * The instance is created for the RebuildAction class.
     *
     * @param serverId the serverId to set
     * @param rebuild the rebuild to set
     * @return the RebuildAction
     */
    public RebuildAction rebuild(String serverId, Rebuild rebuild) {
        return new RebuildAction(serverId, rebuild);
    }

    /**
     * The class ResizeAction extends the Server class from the Nova Model.
     */
    public class ResizeAction extends Action<Server> {

        /**
         * The instance is created for the Resize class.
         */
        private Resize action;

        /**
         * The created instance is used to access the ResizeAction class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public ResizeAction(String id, Resize action) {
            super(id, Entity.json(action), Server.class);
        }

    }

    /**
     * The instance is created for the ResizeAction class.
     *
     * @param serverId the serverId to set
     * @param flavorId the flavorId to set
     * @param diskConfig the diskConfig to set
     * @return the ResizeAction
     */
    public ResizeAction resize(String serverId, String flavorId,
            String diskConfig) {
        Resize resize = new Resize();
        resize.setFlavorRef(flavorId);
        resize.setDiskConfig(diskConfig);
        return new ResizeAction(serverId, resize);
    }

    /**
     * The class ConfirmResizeAction extends the Server class from the Nova
     * Model.
     */
    public class ConfirmResizeAction extends Action<Server> {

        /**
         * Converts the Entity to json.
         *
         * @param id the id to set
         */
        public ConfirmResizeAction(String id) {
            super(id, Entity.json(new ConfirmResize()),
                    Server.class);
        }

    }

    /**
     * The instance is created for the class ConfirmResizeAction .
     *
     * @param serverId the serverId to set
     * @return the ConfirmResizeAction
     */
    public ConfirmResizeAction confirmResize(String serverId) {
        return new ConfirmResizeAction(serverId);
    }

    /**
     * The class RevertResizeAction extends the Server class from the Nova
     * Model.
     */
    public class RevertResizeAction extends Action<Server> {

        /**
         * Converting to json.
         *
         * @param id the id to set
         */
        public RevertResizeAction(String id) {
            super(id, Entity.json(new RevertResize()),
                    Server.class);
        }

    }

    /**
     * The instance is created for the RevertResizeAction class.
     *
     * @param serverId the serverId to set
     * @return the RevertResizeAction
     */
    public RevertResizeAction revertResize(String serverId) {
        return new RevertResizeAction(serverId);
    }

    /**
     * The class CreateImageAction extends the Action class.
     */
    public class CreateImageAction extends Action<Void> {

        /**
         * The instance is created for the CreateImage class and is used to
         * access the CreateImageAction.
         *
         * @param id the id to set
         * @param createImage the createImage to set
         */
        public CreateImageAction(String id, CreateImage createImage) {
            super(id, Entity.json(createImage), Void.class);
        }

    }

    /**
     * The instance is created for the CreateImageAction class.
     *
     * @param serverId the serverId to set
     * @param name the name to set
     * @param metadata the metadata to set
     * @return the serverId and createImage
     */
    public CreateImageAction createImage(String serverId, String name,
            Map<String, String> metadata) {
        CreateImage createImage = new CreateImage();
        createImage.setName(name);
        createImage.setMetadata(metadata);
        return new CreateImageAction(serverId, createImage);
    }

    /**
     * The class StartServer extends the OpenStackrequest class.
     */
    public class StartServer extends OpenStackRequest<Void> {

        /**
         * The instance is created for the Start.
         */
        private Start action;
        /**
         * Identifier for the StartServer class.
         */
        private String id;

        /**
         * POST the id.
         *
         * @param id the id to set
         */
        public StartServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Start()), Void.class);
        }
    }

    /**
     * The class StopServer extends the OpenStackRequest class.
     */
    public class StopServer extends OpenStackRequest<Void> {

        /**
         * The instance is created for the Stop class.
         */
        private Stop action;
        /**
         * Identifier of the StopServer.
         */
        private String id;

        /**
         * POST the id.
         *
         * @param id the id to set
         */
        public StopServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Stop()), Void.class);
        }
    }

    /**
     * Instance is created for the StartServer class.
     *
     * @param id the id to set
     * @return the StartServer
     */
    public StartServer start(String id) {
        return new StartServer(id);
    }

    /**
     * The instance is created for the StopServer class.
     *
     * @param id the id to set
     * @return the StopServer
     */
    public StopServer stop(String id) {
        return new StopServer(id);
    }

    /**
     * The class GetVncConsoleSerever extends the VncConsole class from the Nova
     * Model.
     */
    public class GetVncConsoleServer extends OpenStackRequest<VncConsole> {

        /**
         * The instance is created for the GetVncConsole class.
         */
        private GetVncConsole action;
        /**
         * The identifier for the GetVncConsoleServer.
         */
        private String id;

        /**
         * The created instance is used to access the GetVncConsoleServer class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public GetVncConsoleServer(String id, GetVncConsole action) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"), Entity.json(action),
                    VncConsole.class);
        }
    }

    /**
     * The instance is created for the GetVncConsoleServer class.
     *
     * @param id the id to set
     * @param type the type to set
     * @return the GetVncConsoleServer
     */
    public GetVncConsoleServer getVncConsole(String id, String type) {
        GetVncConsole action = new GetVncConsole(type);
        return new GetVncConsoleServer(id, action);
    }

    /**
     * The class GetConsoleOutputSerevr extends the ConsoleOutput class.
     */
    public class GetConsoleOutputServer extends
            OpenStackRequest<ConsoleOutput> {

        /**
         * The instance created is used to access the GetConsoleOutputServer
         * class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public GetConsoleOutputServer(String id,
                GetConsoleOutput action) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"), Entity.json(action),
                    ConsoleOutput.class);
        }
    }

    /**
     * The instance is created for the GetConsoleOutputServer class.
     *
     * @param id the id to set
     * @param length the length to set
     * @return the GetConsoleOutputServer
     */
    public GetConsoleOutputServer getConsoleOutput(String id, int length) {
        GetConsoleOutput action = new GetConsoleOutput(length);
        return new GetConsoleOutputServer(id, action);
    }

    /**
     * The class PauseServer extends the OpenStackRequest class.
     */
    public class PauseServer extends OpenStackRequest<Void> {

        /**
         * The instance is used to access the PauseServer class.
         *
         * @param id the id to set
         */
        public PauseServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id).
                    append("/action"),
                    Entity.json(new Pause()), Void.class);
        }
    }

    /**
     * The class UnpauseServer extends the OpenStackRequest class.
     */
    public class UnpauseServer extends OpenStackRequest<Void> {

        /**
         * The instance is used to access the UnpauseServer class.
         *
         * @param id the id to set
         */
        public UnpauseServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Unpause()), Void.class);
        }
    }

    /**
     * The class LookServer extends the OpenStackRequest class.
     */
    public class LockServer extends OpenStackRequest<Void> {

        /**
         * The instance is created for the Lock class.
         */
        private Lock action;
        /**
         * Identifier for the LockServer class.
         */
        private String id;

        /**
         * The instance is use to access the LockServer class.
         *
         * @param id the id to set
         */
        public LockServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id).
                    append("/action"),
                    Entity.json(new Lock()), Void.class);
        }
    }

    /**
     * The class UnloackServer extends the OpenStackRequest class.
     */
    public class UnlockServer extends OpenStackRequest<Void> {

        /**
         * The instance is created for the Unlock class.
         */
        private Unlock action;
        /**
         * Identifier for the UnlockServer class.
         */
        private String id;

        /**
         * The instance is used to access the UnlockServer class.
         *
         * @param id the id to set
         */
        public UnlockServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Unlock()), Void.class);
        }
    }

    /**
     * The SuspendServer class extends the OpenStackRequest class.
     */
    public class SuspendServer extends OpenStackRequest<Void> {

        /**
         * The instance is used to access the SuspendServer class.
         *
         * @param id the id to set
         */
        public SuspendServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Suspend()), Void.class);
        }
    }

    /**
     * The ResumeServer class extends the OpenStackRequest class.
     */
    public class ResumeServer extends OpenStackRequest<Void> {

        /**
         * The instance is used to access the ResumeServer class.
         *
         * @param id the id to set
         */
        public ResumeServer(String id) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id)
                    .append("/action"),
                    Entity.json(new Resume()), Void.class);
        }
    }

    /**
     * The class createBackupServer class extends the OpenStackRequest class.
     */
    public class CreateBackupServer extends OpenStackRequest<Void> {

        /**
         * The instance of a CreateBackupServer class is used to access the
         * CreateBackupServer class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public CreateBackupServer(String id, CreateBackup action) {
            super(CLIENT, HttpMethod.POST,
                    new StringBuilder("/servers/").append(id).
                    append("/action"),
                    Entity.json(action), Void.class);
        }
    }

    /**
     * The instance is created for the PauseServer class.
     *
     * @param serverId the serverId to set
     * @return the PauseServer
     */
    public PauseServer pause(String serverId) {
        return new PauseServer(serverId);
    }

    /**
     * The instance is created for the UnpauseServer class.
     *
     * @param serverId the serverid to set
     * @return the UnpauseServer
     */
    public UnpauseServer unpause(String serverId) {
        return new UnpauseServer(serverId);
    }

    /**
     * The instance is created for the LockServer class.
     *
     * @param serverId the serverId to set
     * @return the LockServer
     */
    public LockServer lock(String serverId) {
        return new LockServer(serverId);
    }

    /**
     * The instance is created for the UnlockServer class.
     *
     * @param serverId the serverId to set
     * @return the UnloackServer
     */
    public UnlockServer unlock(String serverId) {
        return new UnlockServer(serverId);
    }

    /**
     * The instance is created for the SuspendServer class.
     *
     * @param serverId the serverId to set
     * @return the SuspendServer
     */
    public SuspendServer suspend(String serverId) {
        return new SuspendServer(serverId);
    }

    /**
     * The instance is created for the ResumeServer class.
     *
     * @param serverId the serverId to set
     * @return the ResumeServer
     */
    public ResumeServer resume(String serverId) {
        return new ResumeServer(serverId);
    }

    /**
     * The instance is created for the CreateBackupServer class.
     *
     * @param serverId the serverId to set
     * @param action the action to set
     * @return the CreateBackupServer
     */
    public CreateBackupServer createBackup(String serverId,
            CreateBackup action) {
        return new CreateBackupServer(serverId, action);
    }

    /**
     * The class RescueServer extends the OpenStackRequest class.
     */
    public class RescueServer extends OpenStackRequest<Void> {

        /**
         * The instance of RescueServer is used to access the RescueServer
         * class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public RescueServer(String id, Rescue action) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/")
                    .append(id).append("/action"), Entity.json(action),
                    Void.class);
        }
    }

    /**
     * The class UnrescueServer extends the OpenStackRequest class.
     */
    public class UnrescueServer extends OpenStackRequest<Void> {

        /**
         * The instance of UnrescueServer is used to access the UnrescueServer
         * class.
         *
         * @param id the id to set
         */
        public UnrescueServer(String id) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/")
                    .append(id).append("/action"), Entity.json(new Unrescue()),
                    Void.class);
        }
    }

    /**
     * The instance is created for the RescueServer class.
     *
     * @param serverId the serverId to set
     * @param adminPass the adminPass to set
     * @return the RescueServer
     */
    public RescueServer rescue(String serverId, String adminPass) {
        Rescue action = new Rescue(adminPass);
        return new RescueServer(serverId, action);
    }

    /**
     * The instance is created for the UnrescueServer class.
     *
     * @param serverId the serverId to set
     * @return the UnrescueServer
     */
    public UnrescueServer unrescue(String serverId) {
        return new UnrescueServer(serverId);
    }

    /**
     * The class AssociateFloatingIp extends the OpenStackRequest class.
     */
    public class AssociateFloatingIp extends OpenStackRequest<Void> {

        /**
         * The instance of AssociateFloatingIp is used to access the
         * AssociateFloatingIp class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public AssociateFloatingIp(String id,
                com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/")
                    .append(id).append("/action"), Entity.json(action),
                    Void.class);
        }
    }

    /**
     * The class DisassociateFloatingIp extends the OpenStackRequest class.
     */
    public class DisassociateFloatingIp extends OpenStackRequest< Void> {

        /**
         * The instance of DisassociateFloatingIp is used to access the
         * DisassociateFloatingIp class.
         *
         * @param id the id to set
         * @param action the action to set
         */
        public DisassociateFloatingIp(String id,
                com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/")
                    .append(id).append("/action"), Entity.json(action),
                    Void.class);
        }
    }

    /**
     * The instance of AssociateFloatingIp is used to access the
     * AssociateFloatingIp class.
     *
     * @param serverId the serverId to set
     * @param floatingIpAddress the floatingIpAddress to set
     * @return the AssociateFloatingIp
     */
    public AssociateFloatingIp associateFloatingIp(String serverId,
            String floatingIpAddress) {
        com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp action
                = new com.woorea.openstack.nova.model.ServerAction.AssociateFloatingIp(floatingIpAddress);
        return new AssociateFloatingIp(serverId, action);
    }

    /**
     * The instance of DisassociateFloatingIp is used to access the
     * DisassociateFloatingIp class.
     *
     * @param serverId the serverId to set
     * @param floatingIpAddress the floatingIpAddress to set
     * @return the DisassociateFloatingIp
     */
    public DisassociateFloatingIp disassociateFloatingIp(String serverId,
            String floatingIpAddress) {
        com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp action = new com.woorea.openstack.nova.model.ServerAction.DisassociateFloatingIp(floatingIpAddress);
        return new DisassociateFloatingIp(serverId, action);
    }

    /**
     * The class AttachVolume extends the OpenStackrequest class.
     */
    public class AttachVolume extends OpenStackRequest<Void> {

        /**
         * The instance of AttachVolume is used to access the AttachVolume
         * class.
         *
         * @param serverId the serverId to set
         * @param volumeAttachment the volumeAttachment to set
         */
        public AttachVolume(String serverId, final VolumeAttachment volumeAttachment) {
            super(CLIENT, HttpMethod.POST, new StringBuilder("/servers/")
                    .append(serverId).append("/os-volume_attachments"),
                    Entity.json(volumeAttachment), Void.class);
        }
    }

    /**
     * The class DetachVolume extends the OpenStackRequest class.
     */
    public class DetachVolume extends OpenStackRequest<Void> {

        /**
         * The instance of DetachVolume is used to access the DetachVolume
         * class.
         *
         * @param serverId the serverId to set
         * @param volumeId the volumeId to set
         */
        public DetachVolume(String serverId, String volumeId) {
            super(CLIENT, HttpMethod.DELETE, new StringBuilder("/servers/")
                    .append(serverId).append("/os-volume_attachments/")
                    .append(volumeId), null, Void.class);
        }
    }

    /**
     * The ListVolumeAttachments class extends the VolumeAttachments class from
     * the Nova Model.
     */
    public class ListVolumeAttachments extends
            OpenStackRequest<VolumeAttachments> {

        /**
         * The instance of ListVolumeAttachments is used to access the
         * ListVolumeAttachments class.
         *
         * @param serverId the serverId to set
         */
        public ListVolumeAttachments(String serverId) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/")
                    .append(serverId).append("/os-volume_attachments"), null,
                    VolumeAttachments.class);
        }
    }

    /**
     * The class ShowVolumeAttachment extends the VolumeAttachments class from
     * the Nova Model.
     */
    public class ShowVolumeAttachment extends
            OpenStackRequest< VolumeAttachment> {

        /**
         * The instance of ShowVolumeAttachment is used to access the
         * ShowVolumeAttachment class.
         *
         * @param serverId the serverId to set
         * @param volumeAttachmentId the volumeAttachmentId to set
         */
        public ShowVolumeAttachment(String serverId, String volumeAttachmentId) {
            super(CLIENT, HttpMethod.GET, new StringBuilder("/servers/")
                    .append(serverId).append("/os-volume_attachments/")
                    .append(volumeAttachmentId), null, VolumeAttachment.class);
        }
    }

    /**
     * The instance is created for the AttachVolume class.
     *
     * @param serverId the serverId to set
     * @param volumeId the volumeId to set
     * @param device the device to set
     * @return the AttachVolume
     */
    public AttachVolume attachVolume(String serverId, String volumeId,
            String device) {
        VolumeAttachment volumeAttachment = new VolumeAttachment();
        volumeAttachment.setVolumeId(volumeId);
        volumeAttachment.setDevice(device);
        return new AttachVolume(serverId, volumeAttachment);
    }

    /**
     * The instance is created for the DetachVolume class.
     *
     * @param serverId the serverId to set
     * @param volumeId the volumeId to set
     * @return the DetachVolume
     */
    public DetachVolume detachVolume(String serverId, String volumeId) {
        return new DetachVolume(serverId, volumeId);
    }

    /**
     * The instance is created for the ListVolumeAttachments class.
     *
     * @param serverId the serverId to set
     * @return the ListVolumeAttachments
     */
    public ListVolumeAttachments listVolumeAttachments(String serverId) {
        return new ListVolumeAttachments(serverId);
    }

    /**
     * The instance is created for the ShowVolumeAttachment class.
     *
     * @param serverId the serverId to set
     * @param volumeAttachmentId the volumeAttachmentId to set
     * @return the ShowVolumeAttachment
     */
    public ShowVolumeAttachment showVolumeAttachment(String serverId,
            String volumeAttachmentId) {
        return new ShowVolumeAttachment(serverId, volumeAttachmentId);
    }
}
