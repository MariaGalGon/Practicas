import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaPaginaprincipaladministrador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
        			margin: 0px;
                }
            </style>
<vaadin-vertical-layout style="align-items: stretch; height: 100%; width: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" id="cabecera" style="align-self: stretch; align-items: center; width: 100%; margin-bottom: var(--lumo-space-xl);">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu" style="align-self: center;">
   <iron-icon icon="lumo:menu"></iron-icon>
  </vaadin-button>
  <img id="boton_logo">
  <h1 id="titulo" style="align-self: center;">Vista de Administrador</h1>
  <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="flex-grow: 1; justify-content: flex-end;">
   <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil" style="align-self: center; flex-grow: 0;">
    <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; align-self: stretch; margin-right: var(--lumo-space-xl); align-items: center;" id="cuerpo">
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; align-items: center;" id="parte_derch">
   <h2 id="bienvenida">Bienvenido/a</h2>
   <img id="logo_grande" style="margin: var(--lumo-space-s);">
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-self: center; margin-right: var(--lumo-space-xl);" id="parte_izq">
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_catalogo">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_catalogo">
      Ver Catálogo 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_ofertas">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_ofertas">
      Ver Ofertas 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_categorias">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_categorias">
      Ver Categorias 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_compras">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_compras">
      Ver Lista de Compras 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_cuentas">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_cuentas">
      Administrar Cuentas 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" id="cuadro_icono_boton" style="align-self: flex-end; align-items: center;">
    <img id="foto_anuncios">
    <vaadin-button style="margin: var(--lumo-space-s);" id="boton_anuncios">
      Gestionar Anuncios 
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-paginaprincipaladministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaPaginaprincipaladministrador.is, VistaPaginaprincipaladministrador);
