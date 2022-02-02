import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import './vista-listaproductosaniadidos.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';

class VistaCarrito extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin: var(--lumo-space-s);" id="cabecera_carrito">
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <vaadin-text-field placeholder="search..." style="flex-grow: 1;" id="barra_busqueda"></vaadin-text-field>
  <vaadin-button style="align-self: center;" id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label style="align-self: center;" id="label_contador"></label>
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center;" id="boton_perfil">
   <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <h2 id="nombre_carrito" style="margin: var(--lumo-space-l);">Carrito</h2>
 <vaadin-horizontal-layout theme="spacing" id="cuerpo_carrito" style="justify-content: space-around; align-self: stretch;">
  <vaadin-horizontal-layout theme="spacing" id="lista_productos" style="flex-grow: 1; flex-wrap: wrap;"></vaadin-horizontal-layout>
  <vaadin-vertical-layout id="cuadro_resumen_carrito" style="flex-grow: 0; width: 50%; margin: var(--lumo-space-xl); flex-shrink: 1;">
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
     Comprar 
   </vaadin-button>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-carrito';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCarrito.is, VistaCarrito);
