import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import './vista-listaimagenes.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import './vista-informacion.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import './vista-listacategoriasproducto.js';
import './vista-vercomentariosgeneral.js';
import './vista-vercaracteristicascibernautas.js';
import './vista-vercaracteristicasadministrador.js';
import './vista-verinformacionadministrador.js';
import './vista-verinformacioncibernauta.js';
import '@vaadin/vaadin-upload/src/vaadin-upload-file.js';
import '@vaadin/vaadin-upload/src/vaadin-upload.js';

class VistaVerproducto extends PolymerElement {
//" draggable="true" vaadin-dnd-layout-item="true" style="width: 100%; height: 100%;
    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;

                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout theme="spacing" style="flex-grow: 0; align-self: stretch; margin: var(--lumo-space-s);" id="cabecera">
  <vaadin-button theme="icon" aria-label="Add new" id="boton_menu">
   <iron-icon icon="lumo:menu" id="icono_menu"></iron-icon>
  </vaadin-button>
  <img id="logo">
  <vaadin-text-field placeholder="search..." style="flex-grow: 1;" id="barra_busqueda"></vaadin-text-field>
  <vaadin-button id="boton_buscar">
    Buscar 
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_carrito">
   <iron-icon icon="vaadin:cart" id="icono_carrito"></iron-icon>
  </vaadin-button>
  <label id="contador_carrito" style="align-self: center; flex-grow: 0;"></label>
  <vaadin-button theme="icon" aria-label="Add new" id="boton_perfil">
   <iron-icon icon="lumo:user" id="icono_perfil"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; align-self: stretch; align-items: flex-start; margin-top: var(--lumo-space-xl);" id="cuerpo">
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 0; align-self: flex-start; margin-top: var(--lumo-space-xl);" id="parte_izquierda">
   <label style="align-self: center; font-weight: bold; font-size: large;" id="nombre_producto_cibernauta">Nombre del producto</label>
   <vaadin-text-field label="Nombre del Producto" id="nombre_producto_admin" style="align-self: center;"></vaadin-text-field>
   <vaadin-horizontal-layout theme="spacing" style="align-self: center; align-items: center;" id="cuadro_imagen">
    <vaadin-button theme="icon" aria-label="Add new" id="desp_izq">
     <iron-icon icon="lumo:angle-left" id="icono_desp_izq"></iron-icon>
    </vaadin-button>
    <img id="foto_producto">
    <vaadin-button theme="icon" aria-label="Add new" id="desp_derch">
     <iron-icon icon="lumo:angle-right" id="icono_desp_derech"></iron-icon>
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-vertical-layout theme="spacing" id="cuadro_seleccion_imagen" style="align-self: center; flex-grow: 0;">
    <vaadin-horizontal-layout id="hueco_lista_imagagenes"></vaadin-horizontal-layout>
    <vaadin-horizontal-layout theme="spacing" id="hueco_upload" style="align-self: stretch;"></vaadin-horizontal-layout>
   </vaadin-vertical-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: center; align-items: center;" id="valoracion_media">
    <img id="estrella_1">
    <img id="estrella_2">
    <img id="estrella_3">
    <img id="estrella_4">
    <img id="estrella_5">
    <label id="contador_valoracion">2</label>
   </vaadin-horizontal-layout>
   <img style="flex-grow: 0; align-self: center;" id="fondo_precio">
   <vaadin-vertical-layout theme="spacing" style="align-self: center;" id="cuadro_precio">
    <label style="align-self: center; font-weight: bold;" id="precio"></label>
    <vaadin-text-field label="Precio:" id="precio_admin" style="align-self: center;"></vaadin-text-field>
    <vaadin-button id="boton_aniadir_carrito" style="align-self: center;">
      Añadir al Carrito 
    </vaadin-button>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; align-items: flex-start;" id="parte_derecha">
   <vaadin-horizontal-layout theme="spacing" style="align-self: flex-end;" id="vaadinHorizontalLayout">
    <vaadin-button id="boton_guardar">
      Guardar 
    </vaadin-button>
    <vaadin-button id="boton_eliminar">
      Eliminar 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-vertical-layout theme="spacing" id="layout_tabs" style="align-self: stretch; flex-grow: 1;"></vaadin-vertical-layout>
   <vaadin-vertical-layout theme="spacing" id="contenido_tabs" style="align-self: stretch; width: 100%; height: 100%;"></vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verproducto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerproducto.is, VistaVerproducto);
