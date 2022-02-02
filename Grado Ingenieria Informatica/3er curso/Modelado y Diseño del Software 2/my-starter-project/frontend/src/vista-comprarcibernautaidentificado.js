import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';

class VistaComprarcibernautaidentificado extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%; align-items: stretch;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin: var(--lumo-space-s); margin-top: var(--lumo-space-l);" id="cabecera_carrito">
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <vaadin-text-field placeholder="search..." style="align-self: center; flex-grow: 1;" id="barra_busqueda"></vaadin-text-field>
  <vaadin-button style="align-self: center;" id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label style="align-self: center;" id="label_contador"></label>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
   <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="margin: var(--lumo-space-m);">
  <vaadin-vertical-layout theme="spacing" id="cuadro_datos_envio" style="margin: var(--lumo-space-m); flex-grow: 1;">
   <h2 id="titulo_datos_envio">Datos de Envío</h2>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-text-field label="Nombre" id="envio_nombre" readonly></vaadin-text-field>
    <vaadin-text-field label="Apellidos" id="envio_apellidos" readonly></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch;" id="vaadinHorizontalLayout">
    <vaadin-text-field label="Dirección de Envío" id="envio_direccion" style="flex-grow: 1;" readonly></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-text-field label="Número de cuenta" id="envio_num_cuenta" readonly></vaadin-text-field>
    <vaadin-text-field label="CVV" id="envio_cvv"></vaadin-text-field>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout id="cuadro_resumen_carrito" style="flex-grow: 0; margin: var(--lumo-space-xl); width: 30%;">
   <h3 id="titulo_resumen" style="align-self: center;">Resumen</h3>
   <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0;">
    <h5>Subtotal:</h5>
    <p id="subtotal"></p>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <h5>Envío:</h5>
    <p id="envio"></p>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <h5>Total:</h5>
    <p id="total"></p>
   </vaadin-horizontal-layout>
   <vaadin-button id="boton_comprar_carrito" style="align-self: center;">
     Realizar Compra 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-comprarcibernautaidentificado';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaComprarcibernautaidentificado.is, VistaComprarcibernautaidentificado);
